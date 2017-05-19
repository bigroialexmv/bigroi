/**
 * 
 */
package com.bigroi.samples.network.messenger;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @author Alexander Medvedev
 *
 */
public class MessageReceiver implements Runnable, Closeable {

	private Socket socket;
	
	private Unmarshaller unmarshaller;
	
	private DataInputStream inputStream;
	
	private MessageListener listener;
	
	private Object source;
	
	private Thread thread;
	
	public MessageReceiver(Socket socket, MessageListener listener) {
		this.socket = socket;
		this.listener = listener;
	}
	
	public MessageReceiver(Socket socket, MessageListener listener, Object source) {
		this(socket, listener);
		this.source = source;		
	}
	
	public void start() {
		// запускаем поток для получения сообщений от сервера и вывода полученных сообщений в консоль клиента
		thread = new Thread(this);
		thread.setDaemon(true);
		thread.start(); // запускаем метод run в отдельном потоке
	}
	
	@Override
	public void run() {
		while ( !socket.isClosed() ) {
			Object o;
			try {
				String data = getInputStream().readUTF();
				o = getUnmarshaller().unmarshal( new StringReader(data) );
				Message message = (Message) o;
				if (listener != null) {
					listener.onMessage(message, source);
				}
			} catch(EOFException e) {			
			} catch (JAXBException | IOException e) {
				e.printStackTrace();
				close();
				break;
			}
		}
	}
	
	@Override	
	public void close() {		
		thread.interrupt();
		try {
			thread.join();
		} catch (InterruptedException ie) {			
		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {				
			}
			inputStream = null;
		}
	}
	
	protected DataInputStream getInputStream() throws IOException {
		if (inputStream == null) {
			inputStream = new DataInputStream( socket.getInputStream() );
		}
		return inputStream;
	}
	
	protected Unmarshaller getUnmarshaller() throws JAXBException {
		if (unmarshaller == null) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
			unmarshaller = jaxbContext.createUnmarshaller();
		}
		return unmarshaller;
	}	

}

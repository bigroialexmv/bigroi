/**
 * 
 */
package com.bigroi.samples.network.messenger;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author Alexander Medvedev
 *
 */
public class MessageSender implements Closeable {
	
	private Socket destination;
	
	private DataOutputStream outputStream;
	
	private Marshaller marshaller;
	
	public MessageSender(Socket socket) {
		if (socket == null) {
			throw new IllegalArgumentException("socket must not be null");
		}
		destination = socket;
	}
	
	public void sendMessage(Message message) throws IOException, JAXBException {
		StringWriter writer = new StringWriter();
		getMarshaller().marshal(message, writer);		
		getOutputStream().writeUTF( writer.toString() ) ;
	}

	@Override
	public void close() throws IOException {
		if (outputStream != null) {
			outputStream.close();
		}		
	}
	
	protected Marshaller getMarshaller() throws JAXBException {
		if (marshaller == null) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
			marshaller = jaxbContext.createMarshaller();
		}
		return marshaller;
	}
	
	protected DataOutputStream getOutputStream() throws IOException {
		if (outputStream == null) {
			outputStream = new DataOutputStream(destination.getOutputStream());
		}
		return outputStream;
	}
	

}

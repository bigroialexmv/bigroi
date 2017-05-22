/**
 * 
 */
package com.bigroi.samples.network.sockets.https;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * @author Alexander Medvedev
 *
 */

class Request {
	
	private String host;
	
	private String[] header;
	
	public Request(String host, String[] header) {
		this.host = host;
		this.header = header;
	}

	public String getHost() {
		return host;
	}

	public String[] getHeader() {
		return header;
	}
	
}

public class HttpRequestSampleApp {
	
	private static byte[] CRLF = "\r\n".getBytes();

	public static void main(String[] args) {
		
		Request tutByGetRequest = new Request(
				"www.tut.by",
				new String[] {
					"GET / HTTP/1.1",
					"Host: www.tut.by"
				}
			);
		doHttpRequest(tutByGetRequest);
	}

	private static void doHttpRequest(Request request) {
		System.out.println("\n --- \n");
		
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = null;
                
		try {
			InetAddress inetAddress = InetAddress.getByName( request.getHost() );
			System.out.println("Requesting address: " + inetAddress);
			
			socket = (SSLSocket) factory.createSocket(inetAddress, 443);
			socket.startHandshake();
			
			sendRequest(request, socket);
			
			recieveResponse(socket);
			
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {					
				}
			}
		}
	}

	private static void recieveResponse(SSLSocket socket) throws IOException {
		System.out.println("Response: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader( socket.getInputStream() /*, Charset.forName("UTF-8") */));
		PrintWriter fileWriter = new PrintWriter("d:\\tutBy.response.txt");
		
		String line = reader.readLine();
		while(line != null) {
			System.out.println( line );
			fileWriter.println( line );
			line = reader.readLine();			
		}
		fileWriter.close();
	}

	private static void sendRequest(Request request, SSLSocket socket) throws IOException {
		/*Charset charset = Charset.forName("US-ASCII");*/
		OutputStream out = socket.getOutputStream();
		for(String line : request.getHeader() ) {
			out.write(line.getBytes());
			out.write(CRLF);				
		}
		out.write("\r\n".getBytes());
		out.flush();
	}

}

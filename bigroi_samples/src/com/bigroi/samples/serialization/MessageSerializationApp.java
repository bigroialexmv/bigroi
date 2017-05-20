/**
 * 
 */
package com.bigroi.samples.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.bigroi.samples.network.messenger.Message;

/**
 * @author Alexander Medvedev
 *
 */
public class MessageSerializationApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Message message = new Message();
		message.put("text", "Hello");
		
		try (ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("d:\\message")) ) {
			dos.writeObject(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream dos = new ObjectInputStream(new FileInputStream("d:\\message")) ) {
			Object o = dos.readObject();
			message = (Message) o;
			System.out.println("Serialized message text: " + message.get("text"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/**
 * 
 */
package com.bigroi.samples.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bigroi.samples.network.messenger.Message;

/**
 * @author Alexander Medvedev
 *
 */
public class MessageXMLSerializationApp {
	
	public static void main(String[] args) {
		Message message = new Message();
		message.put("text", "Hello");
		message.put("from", "Alex");
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);			
			jaxbMarshaller.marshal(message, System.out);
			
		} catch (JAXBException e) {			
			e.printStackTrace();
		}
	}

}

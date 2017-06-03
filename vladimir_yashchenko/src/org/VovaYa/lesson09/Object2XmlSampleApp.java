package org.VovaYa.lesson09;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class Object2XmlSampleApp {

	public static void main(String[] args) {
		Product p = new Product("002", "iPhone", 400);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
			Marshaller jaxbMarshller = jaxbContext.createMarshaller();
			jaxbMarshller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshller.marshal(p, new File ("C:\\JavaVovik\\workspace\\vladimir_yashchenko1\\xml_samples\\product_002.xml"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}

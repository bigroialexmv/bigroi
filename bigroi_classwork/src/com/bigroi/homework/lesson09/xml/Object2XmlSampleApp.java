package com.bigroi.homework.lesson09.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Object2XmlSampleApp {

	public static void main(String[] args) {
		Product p = new Product("002", "iPhone", 400);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);	
			jaxbMarshaller.marshal(p, new File("C:\\Users\\םנ615\\git\\bigroi\\bigroi_classwork\\xml_samples\\product_002.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

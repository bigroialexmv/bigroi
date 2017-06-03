package com.bigroi.homework.lesson09.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Xml2ObjectSampleApp {

	public static void main(String[] args) {
		
		String xmlFileName = "C:\\Users\\םנ615\\git\\bigroi\\bigroi_classwork\\xml_samples\\product_001.xml";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
			Unmarshaller jaxbUnarshaller = jaxbContext.createUnmarshaller();			
			Object obj = jaxbUnarshaller.unmarshal(new File(xmlFileName));
			Product p = (Product) obj;
			
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

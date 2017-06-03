package lesson09;

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
			jaxbMarshaller.marshal( p, new File("D:\\eclipse_workspace_J4_git\\bigroi\\sergey_morozov\\src\\xml_samples\\product_002.xml") );
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}

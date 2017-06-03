package com.bigroi.homework.lesson09.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParserSampleApp {

	public static void main(String[] args) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(
					new File("C:\\Users\\םנ615\\git\\bigroi\\bigroi_classwork\\xml_samples\\product_001.xml"));
			Element root = doc.getDocumentElement();
			System.out.println( root.getNodeName() ); 
			NodeList childs = root.getChildNodes();
			for(int i=0 ; i<childs.getLength(); i++) {
				Node node = childs.item(i);
				if (node instanceof Element) {
					System.out.print( node.getNodeName() + "=");
					Element e = (Element) node;
					System.out.println( e.getTextContent() );
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

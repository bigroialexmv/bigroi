package com.bigroi.homework.lesson09.xml;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

class SAXHandler extends DefaultHandler {
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {		
		super.startElement(uri, localName, qName, attributes);
		System.out.println("elem: " + localName + " " + qName);
	}	
	
}

public class SAXParserSampleApp {

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            InputStream    xmlInput  =
                new FileInputStream("C:\\Users\\םנ615\\git\\bigroi\\bigroi_classwork\\xml_samples\\product_001.xml");

            SAXParser      saxParser = factory.newSAXParser();
            SAXHandler handler   = new SAXHandler();
            saxParser.parse(xmlInput, handler);

           
        } catch (Throwable err) {
            err.printStackTrace ();
        }

	}

}

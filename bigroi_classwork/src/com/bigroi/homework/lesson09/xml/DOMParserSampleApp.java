package com.bigroi.homework.lesson09.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class DOMParserSampleApp {

	public static void main(String[] args) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(
					new File("C:\\Users\\םנ615\\git\\bigroi\\bigroi_classwork\\xml_samples\\product_001.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

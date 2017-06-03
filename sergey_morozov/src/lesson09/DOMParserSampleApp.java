package lesson09;

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
			Document doc = db.parse(new File("D:\\eclipse_workspace_J4_git\\bigroi\\sergey_morozov\\src\\xml_samples\\product_001.xml"));
			Element root = doc.getDocumentElement();
			System.out.println(root.getNodeName());
			NodeList childs = root.getChildNodes();
			for (int i = 0; i < childs.getLength(); i++) {
				Node node = childs.item(i);
				if (node instanceof Element){
				System.out.println( node.getNodeName() );
				Element e = (Element) node;
				System.out.println(e.getTextContent());
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	
}

package lesson09;

		import java.io.File;

		import javax.xml.bind.JAXBContext;
		import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


		public class Xml2ObjectSampleApp {

			public static void main(String[] args) {
				String s = "D:\\eclipse_workspace_J4_git\\bigroi\\sergey_morozov\\src\\xml_samples\\product_001.xml";
				
				try {
					JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
					Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();
					jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					Object obj = jaxbMarshaller.unmarshal( new File(s) );
					Product p = (Product) obj;
					System.out.println(p);
				} catch (Exception e) {
					
					e.printStackTrace();
				}

			}

		

	}



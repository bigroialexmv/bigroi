package homeworks.homework05;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ListFilesSampleApp {

	

	public static void main(String[] args) {
				
		String dir = "E:\\Саша";
		File file = new File (dir);
		if (file.exists() )
			System.out.println("Directory " + dir + " contains: ");
		
        try (FileWriter dataFile = new FileWriter("E:\\data.txt");
        		FileReader reader = new FileReader ("E:\\data.txt")) {
		ListFilesSample lf = new ListFilesSample(file, dataFile);
       
       
		
		System.out.println("******************************");
		System.out.println();
		lf.printFileExt(file, ".jpg");
		
		System.out.println("******************************");
		System.out.println();
		
		StringBuffer s = new StringBuffer("");
		int c;
		while (reader.read() != -1) {
			c = reader.read();
//			System.out.print((char) c);
		    s.append(c);
		   
		}
		String str = s.toString();
		String [] words = str.split(" ");
		System.out.println("Words in file: " + words.length);
        } catch (IOException e) {
        	e.printStackTrace();
        }
		
		

}
}
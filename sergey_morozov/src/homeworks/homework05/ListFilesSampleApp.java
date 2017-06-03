package homeworks.homework05;

import java.io.BufferedReader;
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
        		BufferedReader reader = new BufferedReader (new FileReader("E:\\data.txt"))) {
		ListFilesSample lf = new ListFilesSample(file, dataFile);
		System.out.println("*************************");
		System.out.println("Strings in file are: " + lf.getCountString());
       System.out.println("Count of directories is: " + lf.getCountDirectories());
       System.out.println("Conut of files is: " + lf.getCountFiles());
		
		System.out.println("******************************");
		System.out.println();
		lf.printExt(file, "jpg");
		
		System.out.println("******************************");
		System.out.println();
		
		StringBuffer s = new StringBuffer("");
		String temp;
		while (reader.readLine() != null) {
			temp = reader.readLine();
//			System.out.println(temp);
		    s.append(temp);
		   
		}
		
		
		String str = s.toString();
		String [] words = str.split("");
		System.out.println("Words in file: " + words.length);
        } catch (IOException e) {
        	e.printStackTrace();
        }
		
		

}
}
package lesson06;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileSampleApp {
	
	public static void main(String[] args) {
		File dir = new File("D:\\temp\\iosample");
		boolean iosampleCreated = dir.mkdir();
		System.out.printf("iosampleCreated = %s\n", iosampleCreated);
		
		iosampleCreated = dir.mkdirs();
		System.out.printf("iosampleCreated = %s\n", iosampleCreated);
		
		boolean iosampleDeleted = dir.delete();
		System.out.printf("iosampleDeleted = %s\n", iosampleDeleted);
		
		iosampleCreated = dir.mkdir();
		System.out.printf("iosampleCreated = %s\n", iosampleCreated);
		
		File file = new File("D:\\temp\\iosample\\test.tst");
		try {
			boolean fileCrteated = file.createNewFile();
			System.out.printf("fileCreated = %s\n", fileCrteated);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] filenames = dir.list();
		for(String fn : filenames) {
			System.out.println(fn);
		}
		System.out.println("********");
		
		FilenameFilter filter = new FilenameFilter() {
			
			@Override
			public boolean accept(File file, String name) {
				//System.out.println(" filtering: " + name);
				return name.endsWith(".txt");
			}
		};
		
		
		filenames = dir.list(filter);
		for(String fn : filenames) {
			System.out.println(fn);
		}
		
		System.out.println("********");
		
		FileFilter fileFilter = new FileFilter() {
			
			
			public boolean accept(File f) {
				
				return f.isFile();
			}
		};
		
		File[] files  = dir.listFiles( fileFilter );
		for (File f : files) {
			System.out.println(f.getAbsolutePath());
		}
		
		System.out.println("*******");
		files  = dir.listFiles( (f) -> f.isFile() );
		for (File f : files) {
			System.out.println(f.getAbsolutePath());
		}
	}

}

package com.bigroi.classwork.lesson06;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

//class MyFilter implements FilenameFilter {			
//	@Override
//	public boolean accept(File file, String name) {
//		
//		return false;
//	}
//};

public class FileSampleApp {

	public static void main(String[] args) {
		File dir = new File("D:\\temp\\iosample");
		
		boolean iosampleCreated = dir.mkdir();
		System.out.printf("iosampleCreated=%s\n", iosampleCreated);
		
		boolean iosampleDeleted = dir.delete();
		System.out.printf("iosampleDeleted=%s\n", iosampleDeleted);
		
		iosampleCreated = dir.mkdirs();
		System.out.printf("iosampleCreated=%s\n", iosampleCreated);
		
		File file = new File("D:\\temp\\iosample\\test.tst");		
		try {
			boolean fileCreated = file.createNewFile();
			System.out.printf("fileCreated=%s\n", fileCreated);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		String[] filenames = dir.list();
		for(String fn : filenames) {
			System.out.println(fn);
		}
		
		System.out.println("******");
		
		FilenameFilter filter = new FilenameFilter() {			
			@Override
			public boolean accept(File file, String name) {
				//System.out.println("  filtering: " + name);
				return name.endsWith(".txt");
			}
		};
		
		filenames = dir.list( filter );
		for(String fn : filenames) {
			System.out.println(fn);
		}	
		
		System.out.println("******");	
		File[] files = dir.listFiles( new FileFilter() {			
				@Override
				public boolean accept(File f) {
					return f.isFile();
				}
			}
		);		
		for(File f : files) {
			System.out.println( f.getAbsolutePath() );
		}
		
		System.out.println("******");
		files = dir.listFiles( (f) -> f.isFile() );
		for(File f : files) {
			System.out.println( f.getAbsolutePath() );
		}
		
	}

}

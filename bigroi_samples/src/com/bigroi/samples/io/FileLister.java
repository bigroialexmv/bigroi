package com.bigroi.samples.io;

import java.io.File;
import java.io.PrintStream;

public class FileLister {
	
	private PrintStream out;
	
	public FileLister(PrintStream out) {
		this.out = out;
	}
	
	public void list(String pathname) {
		File file = new File(pathname);
		list(file);
	}
	
	public void list(File file) {
		list(file, 1);
	}
	
	protected void list(File file, int level) {
		long fileLength = countLength(file);
		if ( file.isDirectory() ) {
			out.printf("%" + (level) + "s %-41s  dir %s bytes (~%s KB, ~%s MB)\n", " ", file.getName(), fileLength, fileLength / 1024, fileLength / 1024 / 1024);
			File[] files = file.listFiles();
			if (files != null) {				
				for(File f : files) {
					list(f, level + 1);					
				}
			}			
		} else {
			out.printf("%" + (level+2) + "s %-40s  file %s\n", " ", file.getName(), countLength(file));
		}		
	}
	
	protected long countLength(File file) {
		if ( file.isFile() ) {
			return file.length();					
		}
		File[] files = file.listFiles();
		long dirLength = 0;
		if (files != null) {			
			for(File f : files) {
				dirLength += countLength(f);				
			}
		}
		return dirLength;
	}

}

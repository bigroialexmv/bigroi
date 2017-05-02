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
	
	/**
	 * 
	 * @param file
	 * @param level - уровень вложенности папки либо файла
	 */
	protected void list(File file, int level) {
		long fileLength = countLength(file);	// вычисляем размер файла или директории
		
		if ( file.isDirectory() ) {
			out.printf("%" + (level*2) + "s %-40s  dir %s bytes (~%s KB, ~%s MB)\n", " ", 
					file.getName(), fileLength, fileLength / 1024, fileLength / 1024 / 1024);
			
			// сначала показываем поддиректории
			File[] files = file.listFiles( (f) -> f.isDirectory() );
			listFiles(files, level + 1);
			
			// потом потом показываем файлы
			files = file.listFiles( (f) -> f.isFile() );
			listFiles(files, level + 1);
		} else {
			out.printf("%" + (level*2-1) + "s|- %-40s  file %s\n", " ", file.getName(), countLength(file));
		}
	}

	private void listFiles(File[] files, int level) {
		if (files != null) {
			for(File f : files) {
				list(f, level + 1);
			}
		}
	}
	/**
	 * Вычисляет размер папки или файла
	 * @param file
	 * @return
	 */
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

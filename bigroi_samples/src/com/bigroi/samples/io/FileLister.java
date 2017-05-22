package com.bigroi.samples.io;

import java.io.File;
import java.io.PrintWriter;

public class FileLister {
	
	private File file;
	
	public FileLister(String pathname) {
		this.file = new File(pathname);
	}
	
	public void list(PrintWriter out) {
		list(file, 1, out);
	}
	
	/**
	 * 
	 * @param file
	 * @param level - уровень вложенности папки либо файла
	 */
	protected void list(File file, int level, PrintWriter out) {
		long fileLength = countLength(file);	// вычисляем размер файла или директории
		
		if ( file.isDirectory() ) {
			out.printf("%" + (level*2) + "s %-40s  dir %s bytes (~%s KB, ~%s MB)\n", " ", 
					file.getName(), fileLength, fileLength / 1024, fileLength / 1024 / 1024);
			
			// сначала показываем поддиректории
			File[] files = file.listFiles( (f) -> f.isDirectory() );
			listFiles(files, level + 1, out);
			
			// потом показываем файлы
			files = file.listFiles( (f) -> f.isFile() );
			listFiles(files, level + 1, out);
		} else {
			out.printf("%" + (level*2-1) + "s|- %-40s  file %s\n", " ", file.getName(), countLength(file));
		}
	}

	private void listFiles(File[] files, int level, PrintWriter out) {
		if (files != null) {
			for(File f : files) {
				list(f, level + 1, out);
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

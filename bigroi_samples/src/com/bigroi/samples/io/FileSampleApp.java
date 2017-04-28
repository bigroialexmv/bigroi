/**
 * 
 */
package com.bigroi.samples.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alexander Medvedev
 *
 */
public class FileSampleApp {
	
	public static void main(String[] args) {
		Logger log = Logger.getLogger("FileSampleApp");
		
		log.log(Level.INFO, "Program started");
		
		// создаем объект файл, который будет ссылаться на директорию d:\temp\testdir
		File dir = new File("d:\\temp1\\testdir");
		System.out.println( dir.getName() + " exists: " + dir.exists() );			// существует ли файл или директория с путем d:\temp\testdir 
		System.out.println( dir.getName() + " isDirectory: " + dir.isDirectory() ); // ссылается ли dir на существующую директоию
		System.out.println( dir.getName() + " isFile: " + dir.isFile() );			// ссылается ли dir на существующий файл
		
		if ( dir.isFile() ) {	// если dir ссылается на существующий файл - выходим из программы
			System.out.printf("Cannot find or create directory %s\n", dir);
			return;
		}
		
		String parent = dir.getParent();	// возвращает директорию, в которой находится файл или папка (d:\temp\testdir)
		System.out.printf( "parent for %s is %s\n", dir, parent);
		
		boolean dirCreated =  dir.mkdirs(); // создает все папки в пути  d:\\temp\\testdir 
											// (если не существует temp - создает temp, далее если не существует testdir - создает testdir)
		System.out.printf( "directory %s created %b\n", dir, dirCreated);
		
		File file = new File(dir, "file.fdb");
		System.out.println(file.getName() + " exists: " + file.exists() );
		
		try {
			boolean fileCreated = file.createNewFile();	// создает новый файл d:\\temp\\testdir\\file.fdb
			System.out.printf( "file %s created %b\n", file, fileCreated);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File testFile = new File(dir, "test.txt");	// создает новый файл d:\\temp\\testdir\\test.txt
		try {
			testFile.createNewFile();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		// выводим в консоль все имена файлов в папке d:\temp\testdir
		System.out.println("Files in " + dir.getPath());
		File[] files = dir.listFiles();
		for(File f : files ) {			
			System.out.println("   " + f);
		}
		
		FileFilter fileFilter = new FileFilter() { // создаем анонимный класс, реализующий интерфейс java.io.FileFilter
			public boolean accept(File f) {	// возращает true, если файл должен быть включен в результат выполнения dir.listFiles (см. ниже)
				String fileName = f.getName();
				return fileName.endsWith(".fdb");
			}
		};
		
		// выводим в консоль все имена файлов в папке d:\temp\testdir, для которых метод fileFilter.accept() возращает true
		System.out.println("FDB files in " + dir.getPath());
		File[] fdbFiles = dir.listFiles( fileFilter );
//		File[] fdbFiles = dir.listFiles( (f) -> f.getName().endsWith(".fdb") ); // лямбда-выражение вместо использования filerFilter
		for(File f : fdbFiles ) {
			System.out.println("   " + f);
		}
	}

}

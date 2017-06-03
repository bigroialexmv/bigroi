/**
 * 
 */
package com.bigroi.samples.io;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @author Alexander Medvedev
 *
 */
public class RandomAccessFileSampleApp {
	
	public static void main(String[] args) {
		
		saveData("t", "D:\\temp\\iosample\\latin.chars");
		
		saveData("э", "D:\\temp\\iosample\\kiryll.chars");
		
	}

	/**
	 * @param data
	 * @param filepath
	 */
	private static void saveData(String data, String filepath) {
		File file = new File(filepath); // создаем объект file, в который будем сохранять данные
		String dirname = file.getParent(); 
		File dir = new File(dirname); // объект dir ссылается на папку с путем D:\temp\iosample 
		dir.mkdirs();	// создаем на диске D папку temp (если не существует), заетем папку iosample (если не существует)
		
		if ( file.exists() ) {
			file.delete();	// удаляем файл, если он уже есть в файловой системе (на диске)
		}
		RandomAccessFile dataFile = null;
		try {
			dataFile = new RandomAccessFile(file, "rw"); // создаем новый файл
			byte[] latinBuffer = data.getBytes();	// преобразуем строку data в массив byte[]
			dataFile.write(latinBuffer); // пишем все байты массива latinBuffer в файл			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ClosableHelper.closeQuitely(dataFile); // закрываем productFile
		}
		// выводим длину файла в консоль
		System.out.printf( "Length of file %s is %s bytes\n", file.getName(),  file.length() );
	}

}

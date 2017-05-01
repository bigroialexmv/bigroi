/**
 * 
 */
package com.bigroi.samples.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Alexander Medvedev
 *
 */
public class CopyFileSampleApp {
	
	public static void main(String[] args) {

		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("D:\\temp\\io\\flight.doc"); // in ссылается на файл, из которого будут читаться данные (байты)
			out = new FileOutputStream("D:\\temp\\io\\flight_copy.doc"); // out ссылается на файл, в который будут писаться данные (байты)
			byte[] buffer = new byte[10]; // массив-буфер
			int bytesReadCount = in.read(buffer); // заполняем buffer первыми 10-ю байтами из копируемого файла
				// bytesReadCount - количество прочитанных байтов; 
				// если длина файла 8 байт, то bytesReadCount = 8, если длина файла >= 10, то bytesReadCount=10
				// если длина файла 0 байт (файл пустой), то bytesReadCount = 0 (копировать нечего)
			while (bytesReadCount > 0) {
				out.write(buffer, 0, bytesReadCount); 
					// пишем в файл байты из массива buffer, начиная с 0-го индекса в количестве bytesReadCount, 
					// т.е. прочиали bytesReadCount байтов, соответсвенно только их и пишем в новый файл
				bytesReadCount = in.read(buffer); // читаем следующие 10 байтов (или сколько осталось прочитать, но не больше 10)
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ClosableHelper.closeQuitely(in);
			ClosableHelper.closeQuitely(out);
		}
		
	}

}

package lesson06;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileSampleApp {

		public static void main(String[] args) {
		File file = new File ("D:\\temp\\iosample\\raf.dat");
		
		try (RandomAccessFile dataFile = new RandomAccessFile(file, "rw")) {
			
				dataFile.writeByte(3);
				dataFile.writeByte(4);
				dataFile.writeByte(5);
				dataFile.seek(2);
				byte b = dataFile.readByte();
                System.out.println(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}



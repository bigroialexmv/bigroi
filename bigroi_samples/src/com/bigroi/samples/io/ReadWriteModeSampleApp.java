/**
 * 
 */
package com.bigroi.samples.io;

import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @author Alexander Medvedev
 *
 */
public class ReadWriteModeSampleApp {

	public static void main(String[] args) {
		try ( Scanner s = new Scanner(System.in) ) {
			String cmd = readInput(s);
			if ( "quit".equals(cmd) ) return;
			while( true ) {
				System.out.println("Opening in mode " + cmd);
				try ( RandomAccessFile file = new RandomAccessFile("D:\\temp\\iosample\\latin.chars", cmd) ) {
					System.out.println("Opened in mode " + cmd);				
				} catch(Exception e) {
					e.printStackTrace();
					break;
				}
				cmd = readInput(s);
				if ( "quit".equals(cmd) ) break;
			}
		}
	}

	/**
	 * @param s
	 * @return
	 */
	private static String readInput(Scanner s) {
		System.out.print("Enter mode or quit: ");
		String cmd = s.nextLine();
		return cmd;
	}
}

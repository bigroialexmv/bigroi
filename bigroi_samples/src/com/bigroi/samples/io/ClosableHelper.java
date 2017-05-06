/**
 * 
 */
package com.bigroi.samples.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Alexander Medvedev
 *
 */
public class ClosableHelper {
	
	private ClosableHelper() {		
	}
	
	public static void closeQuitely(Closeable closeable) {
		if (closeable == null) {
			return;
		}
		try {
			closeable.close();
			System.out.println(closeable + " closed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

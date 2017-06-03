package com.bigroi.classwork.lesson05.shop;

import java.io.PrintWriter;

public class ProductApp {

	public static void main(String[] args) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("ZD:\\product.fdb");
			writer.write( "Products:\n" );
		} catch (Exception e) {			
			e.printStackTrace();
			return;
		} finally {
			System.out.println("Finally !");
			if (writer != null) {
				writer.close();
			}
		}

	}

}

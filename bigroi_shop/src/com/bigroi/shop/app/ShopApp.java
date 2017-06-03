/**
 * 
 */
package com.bigroi.shop.app;

import java.util.Scanner;

import com.bigroi.shop.controller.CommandController;
import com.bigroi.shop.controller.CommandResolver;

/**
 * @author Alexander Medvedev
 *
 */
public class ShopApp {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {		
		CommandResolver commandResolver = new CommandResolver(Configuration.SHOP_COMMANDS_PROPERTIES_FILE);
		CommandController controller = new CommandController(commandResolver);
		final Scanner consoleScanner = new Scanner(System.in);
		try {
			controller.excute(consoleScanner);
		} finally {
			consoleScanner.close();
		}
	}

}

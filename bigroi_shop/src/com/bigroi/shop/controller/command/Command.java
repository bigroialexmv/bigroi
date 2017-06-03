/**
 * 
 */
package com.bigroi.shop.controller.command;

import java.util.Scanner;

/**
 * @author Alexander Medvedev
 *
 */
public abstract class Command {

	public abstract void execute(Scanner scanner) throws Exception;
	
}

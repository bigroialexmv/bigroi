/**
 * 
 */
package com.bigroi.shop.controller;

import java.util.Scanner;

import com.bigroi.shop.controller.command.Command;

/**
 * @author Alexander Medvedev
 *
 */
public class CommandController {
	
	private CommandResolver commandResolver;
	
	public CommandController(CommandResolver commandResolver) {
		super();
		this.commandResolver = commandResolver;
	}

	public void excute(Scanner scanner) throws Exception {
		String cmd = null;
		while ( true ) {
			System.out.println("Enter command: ");
			cmd = scanner.nextLine();
			if ( "quit".equals(cmd) ) {
				break;
			}
			Command command = commandResolver.resolveCommandByName(cmd);
			if (command == null) {
				System.out.print("Invalid command.");
				printSupportedCommands();
			} else {
				command.execute(scanner);
			}
		}
	}

	/**
	 * 
	 */
	private void printSupportedCommands() {
		System.out.println("Supported commands:");
		for(Object c : commandResolver.getSupportedCommands() ) {
			System.out.println(" " + c);
		}
		System.out.println(" quit");
	}

}

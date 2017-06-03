/**
 * 
 */
package com.bigroi.shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import com.bigroi.shop.controller.command.Command;

/**
 * @author Alexander Medvedev
 *
 */
public class CommandResolver {
	
	private Properties commandProperties;
	
	public CommandResolver(String file) throws IOException {
		commandProperties = readProperties(file);
	}
	
	@SuppressWarnings("unchecked")
	public Command resolveCommandByName(String name) {
		String commandClassName = commandProperties.getProperty(name);
		if ( commandClassName == null ) {
			return null;
		}
		try {
			Class<Command> commandClass =  (Class<Command>) Class.forName(commandClassName);
			return commandClass.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Collection<Object> getSupportedCommands() {
		return commandProperties.keySet();
	}

	private Properties readProperties(String file) throws IOException {
		Properties commandProps = new Properties();
		InputStream propsIn = CommandResolver.class.getClassLoader().getResourceAsStream(file);
		try {
			commandProps.load(propsIn);
		} finally {
			propsIn.close();
		}
		return commandProps;
	}

}

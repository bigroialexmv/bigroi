package org.VovaYa.lesson08.sockets.rexes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExecuterApp {
	
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)){
			while (true){
				String cmd = s.nextLine();
				if(cmd.equals("quit")){
					break;
				}
				Process p = Runtime.getRuntime().exec(cmd);
				BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line = null;
				while ((line = r.readLine()) != null){
					System.out.println(line);
				}
			}
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

}

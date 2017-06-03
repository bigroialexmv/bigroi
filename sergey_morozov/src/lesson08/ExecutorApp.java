package lesson08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExecutorApp {

	public static void main(String[] args) {
		
			while (true) {
				try (Scanner s = new Scanner(System.in)) {
					String cmd = s.nextLine();
					if (cmd.equals("quit")) {
						break;
					}
				
				
			Process p = Runtime.getRuntime().exec(cmd);
			Thread.sleep(3000);
			BufferedReader br = new BufferedReader(new InputStreamReader( p.getInputStream(), "UTF-8") ) ;
//			p.destroy();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

}
	}
}

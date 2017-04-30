package homeworks.homework04;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Scanner;


public class UserApp {
	
	public static void main(String[] args) throws Exception {
		
		UserService userService = new UserServiceMockImpl();		

		// создаем объект file, в конструкторе указываем путь к файлу, с которым хотим работать
		File file = new File("E:\\Bigroi_docs\\users_1.fdb"); /* (1) */
		boolean fileExists = file.exists(); 
		if ( fileExists ) {	// если файл существует
			// создаем объект reader, который умеет читать данные из файла
			InputStreamReader reader = new FileReader( file );
			// создаем Sanner и передаем в него reader, 
			// объект scanner будет исрользовать методы reader-a при вызове scanner.nextLine() 
			Scanner scanner = new Scanner(reader);
			
			// вызов метода readInput в конечном итоге считывает строки из файла E:\\Bigroi_docs\\user_1.fdb
			// создает и добавляет объекты User в поле-мапу emailUserMap, хранимое в объекте userService
			readInput( userService, scanner );
		}
		
		System.out.println();
		
		// поле System.in (является объектом интерфейса InputStream) используем для создания сканера,
		// считывающего данные, вводимые пользователем из консоли
		
		Scanner scanner = new Scanner( System.in );
		// считываем команды и данные из консоли, создаем объекты Product и добавляем их в поле codeProductMap (в объекте productService)
		readInput(userService, scanner);
		
		// Сохраняем в файл построчно поля объектов класса User, а также комманды, которые затем будут использоваться
		// при новом запуске приложения в (1) (чтобы использовать один и тот же метод - readInput - как для консольного ввода, 
		// так и для чтения комманд из файла)
		FileWriter writer = new FileWriter("E:\\Bigroi_docs\\users_1.fdb");
		Collection<User> users = userService.findAllUsers();
		for(User u : users) {
			writer.write("addu");
			writer.write("\n");
			writer.write(u.getFirstName());
			writer.write("\n");
			writer.write(u.getLastName());
			writer.write("\n");
			writer.write( u.getEmail());
			writer.write("\n");
		}
		writer.write("quit");
		writer.write("\n");
		writer.close();
		// 
		
		System.out.println();		
		System.out.print("Program exited");
	}

	/**
	 * C помощью Scanner читает команды и данные, вводимые пользователем из консоли, либо из файла
	 * (в зависимости от того как был создан scanner)
	 * @param productService
	 * @param scanner
	 * @throws Exception
	 */
	private static void readInput(UserService userService, Scanner scanner) throws Exception {
		while (true) {
			System.out.print("Enter command: ");
			String userCommand =  scanner.nextLine();
			if ( "quit".equals( userCommand ) ) {
				break;
			} else if ("addu".equals( userCommand )) {
								
				System.out.print("Enter user's first name: ");
				String firstName = scanner.nextLine();
				
				System.out.print("Enter user's last name: ");
				String lastName = scanner.nextLine();
				
				System.out.print("Enter user email: ");
				String email = scanner.nextLine();
				
				User user = new User(firstName, lastName, email);
				userService.saveUser(user);
			} else if ("showu".equals( userCommand ) ) {
				System.out.print("Enter user email: ");
				String email = scanner.nextLine();
				User u = userService.findUserByEmail(email);
				System.out.println( u );
			} else {
				System.out.println("Invalid command. Commands available: addu, showu or quit");
			}
		}
		scanner.close();
	}
}


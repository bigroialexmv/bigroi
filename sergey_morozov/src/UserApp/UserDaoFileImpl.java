package UserApp;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UserDaoFileImpl implements Closeable {
	
	private RandomAccessFile dataFile = null;
	
	public UserDaoFileImpl() throws DaoException {
		try {
			File dir = new File("E:\\temp\\database");
			dir.mkdirs();
			if ( !dir.exists() ) {
				throw new DaoException("Wrong path to data file " + dir.getAbsolutePath());
			}
			dataFile = new RandomAccessFile("D:\\temp\\database\\users.dbt", "rw");
		} catch (FileNotFoundException e) {
			throw new DaoException("Could not initialize data file", e);
		}
	}

	/**
	 * Сохраняет объект User в файл путем создания записи в файле длиной 300 байт. Запись состоит из 3-х частей (полей):
	 *   - поле firstName - имеет длину 100 байт 
	 *   - поле lastName - имеет длину 100 байт
	 *   - поле email - имеет длину 100 байта
	 * @param user
	 * @throws DaoException
	 */	
	public void insertUser(User user) throws DaoException {
		// buffer - массив-буфер - заполняем его данными из объекта
		// firstName будет храниться в buffer начиная с индекса 0 и заканчивая индексом 99: [0,99]
		// lastName будет храниться в диапазоне индексов 100 и 199 (включая): [100, 199] 
		// email будет храниться в диапазоне [200, 299]
		byte[] buffer = new byte[300];
		
		// преобразуем символы поля firstName в массив байтов
		String firstName = user.getFirstName();
		byte[] fnBuffer = firstName.getBytes();
		// проверяем длину массива; если превосходит 100, то выбрасываем исключение
		if (fnBuffer.length > 100) {
			throw new DaoException("Could not write to file");
		}
		// копируем все байты из массива firstNameBuffer в массив buffer		
		System.arraycopy(
				fnBuffer, 
				0 /* индекс массива fnBuffer, начиная с которого берем байты из fnBuffer */, 
				buffer, 
				0 /* индекс массива buffer, начиная с которого пишем байты в buffer */, 
				fnBuffer.length /* количество копируемых байтов из firstNameBuffer - весь массив в нашем случае*/
				);
		
		// записываем name в buffer
		String lastName = user.getLastName();
		byte[] lnBuffer = lastName.getBytes();
		if (lnBuffer.length > 100) {
			throw new DaoException("Could not write to file");
		}
		System.arraycopy(lnBuffer, 0, buffer, 100, lnBuffer.length);
		
		
		// записываем email в buffer
		String email = user.getEmail();
		
		byte[] eBuffer = email.getBytes();
		if (eBuffer.length > 100) {
			throw new DaoException("Could not write to file");
		}
		System.arraycopy(eBuffer, 0, buffer, 200, eBuffer.length);
		
		try {
			// пишем наш buffer в файл
			dataFile.seek(dataFile.length());
			dataFile.write(buffer);
		} catch (IOException e) {
			throw new DaoException("Could not write to file", e);
		}
		
	}
	
	/**
	 * Читает из файла запись с номером n; прочитанные поля помещает в новый объект user
	 * @param n
	 * @return - user
	 * @throws DaoException
	 */
	public User getUserByRecordNo(int n) throws DaoException {
		User user = null;
		try {
			// n * 300 - индекс байта, начиная с которого будем считывать поля из файла			 
			dataFile.seek(n * 300);
			
			// читаем 1-ые 100 байт в массив fnBuffer
			byte[] fnBuffer = new byte[100];
			dataFile.read(fnBuffer);
			// преобразуем массив fnBuffer в строку
			String firstName = new String(fnBuffer);
			// удаляем пробелы слева / справа
			firstName = firstName.trim();
			
			// читаем следующие 100 байт и т.д.
			byte[] lnBuffer = new byte[100];
			dataFile.read(lnBuffer);
			String lastName = new String(lnBuffer).trim();
			
			byte[] eBuffer = new byte[100];
			dataFile.read(eBuffer);
			String email = new String(eBuffer).trim();
			
			user = new User(firstName, lastName, email);
		} catch (IOException e) {
			throw new DaoException("Could not read file", e);
		}		
		return user;
	}
	
//	public Product getProductByCode(String code) throws DaoException {
//		Product product = null;//new Product();
//		return product;
//	}

	@Override
	public void close() {
		if (dataFile != null) {
			try {
				dataFile.close();
				System.out.println("Product data file is closed");
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
}


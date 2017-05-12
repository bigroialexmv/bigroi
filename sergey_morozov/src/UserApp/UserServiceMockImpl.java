package UserApp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserServiceMockImpl implements UserService  {
	// в поле codeUserMap храним всеx юзеров, получаемые при вводе пользователем либо из файла при запуске приложения
	private Map<String, User> emailUserMap = new HashMap<String, User>();

	/**
	 * Находит объект User по его мылу в мапе
	 */
	@Override
	public User findUserByEmail(String email) throws Exception {
		return emailUserMap.get( email );
	}

	/**
	 * Добавляет в мапу объект User, в качестве ключа берется код юзера
	 */
	@Override
	public void saveUser(User user) throws Exception {
		String email = user.getEmail();
		emailUserMap.put( email, user );
	}
	
	//
	// Возвращает все продукты, хранимые в мапе в новом объекте   
	//
	public Collection<User> findAllUsers() throws Exception {
		Collection<User> users = emailUserMap.values();
		return users;
	}
}

	

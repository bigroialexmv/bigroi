package homeworks.homework04;

import java.util.Collection;

public interface UserService {
	public User findUserByEmail(String email) throws Exception;
	public void saveUser(User user) throws Exception;
	public Collection<User> findAllUsers() throws Exception;
}


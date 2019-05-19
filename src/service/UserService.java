package service;

import java.util.ArrayList;

import model.User;

public interface UserService extends SuperService {

	ArrayList<User> getAllUsers() ;
	User getUserById(int id) ;
	boolean updateUser(User user);
	int addUser(User user, byte[] salt);
	boolean deleteUser(int userId);
}

package service;

import java.util.ArrayList;

import model.User;

public interface UserService extends SuperService {

	ArrayList<User> getAllUsers() ;
	User getUserById(int id) ;
	String updateUser(User user);
	int addUser(User user, byte[] salt);
	String deleteUser(int userId);
}

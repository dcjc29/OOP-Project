package service;

import java.util.ArrayList;

import model.User;

public interface UserService extends SuperService {

	ArrayList<User> getAllUsers() ;
}

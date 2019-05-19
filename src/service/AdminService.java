package service;

import java.util.ArrayList;

import model.User;

public interface AdminService extends SuperService{

	boolean addAdmin(User user, byte[] salt,int admin);
	ArrayList<User> getAllAdmins();
	User getAdminById(int id);
	boolean updateAdmin(User admin);
	boolean deleteAdmin(int adminId);

}

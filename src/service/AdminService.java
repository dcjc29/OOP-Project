package service;

import java.util.ArrayList;

import model.User;

public interface AdminService extends SuperService{

	String addAdmin(User user, byte[] salt,int admin);
	ArrayList<User> getAllAdmins();
	User getAdminById(int id);
	String updateAdmin(User admin);
	String deleteAdmin(int adminId);

}

package controller;

import java.util.ArrayList;

import model.User;
import service.AdminService;
import service.ServiceFactory;
import service.ServiceFactoryImpl;


public class AdminController {

	 public static boolean addAdmin(User user,byte[] salt,int id){
	        AdminService adminService = (AdminService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.ADMIN);
	        return adminService.addAdmin(user,salt,id);
	    }

	    public static boolean updateAdmin(User user){
	        AdminService adminService = (AdminService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.ADMIN);
	        return adminService.updateAdmin(user);
	    }

	    public static boolean deleteAdmin(int id){
	        AdminService adminService = (AdminService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.ADMIN);
	        return adminService.deleteAdmin(id);
	    }

	    public static User getAdminById(int id){
	    	AdminService adminService = (AdminService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.ADMIN);
	        return adminService.getAdminById(id);
	    }
	    
	    public static ArrayList<User> getAllAdmins(){
	        AdminService adminService = (AdminService) ServiceFactoryImpl.getInstance()
	                .getService(ServiceFactory.ServiceType.ADMIN);
	        return adminService.getAllAdmins();
	    }
}

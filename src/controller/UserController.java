package controller;

import java.io.InputStream;
import java.util.ArrayList;

import model.Item;
import model.User;
import service.UserService;
import service.ServiceFactory;
import service.ServiceFactoryImpl;

public class UserController {


    public static int addUser(User user,byte[] salt){
        UserService userService = (UserService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.USER);
        return userService.addUser(user,salt);
    }

    public static boolean updateUser(User user){
        UserService userService = (UserService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.USER);
        return userService.updateUser(user);
    }

    public static boolean deleteUser(int id){
        UserService userService = (UserService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.USER);
        return userService.deleteUser(id);
    }

    public static User getUserById(int id){
    	UserService userService = (UserService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.USER);
        return userService.getUserById(id);
    }
    
    public static ArrayList<User> getAllUsers(){
        UserService itemService = (UserService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.USER);
        return itemService.getAllUsers();
    }

}

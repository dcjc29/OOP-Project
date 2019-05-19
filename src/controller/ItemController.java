package controller;

import java.io.InputStream;
import java.util.ArrayList;

import model.Item;
import model.User;
import service.ItemService;
import service.ServiceFactory;
import service.ServiceFactoryImpl;

public class ItemController {

    public static boolean addItem(Item item,InputStream in,User seller){
        ItemService itemService = (ItemService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.ITEM);
        return itemService.addItem(item, in, seller);
    }

    public static boolean updateItem(Item item){
        ItemService itemService = (ItemService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.ITEM);
        return itemService.updateItem(item);
    }

    public static boolean deleteItem(Item item){
        ItemService itemService = (ItemService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.ITEM);
        return itemService.deleteItem(item);
    }

    public static Item getItemByID(int id){
        ItemService itemService = (ItemService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.ITEM);
        return itemService.getItemByID(id);
    }
    
    public static ArrayList<Item> getRecentItems(){
        ItemService itemService = (ItemService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.ITEM);
        return itemService.getRecentItems();
    }

    public static ArrayList<Item> getItemsBySearch(String category,String keywords){
        ItemService itemService = (ItemService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.ITEM);
        return itemService.getItemsBySearch(category,keywords);
    }

    public static ArrayList<Item> getItemsBySearch(String keywords){
        ItemService itemService = (ItemService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.ITEM);
        return itemService.getItemsBySearch(keywords);
    }
    
    public static ArrayList<Item> getItemsByCategory(String category){
        ItemService itemService = (ItemService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.ITEM);
        return itemService.getItemsByCategory(category);
    }

    public static ArrayList<Item> getItemsByUserId(int id){
        ItemService itemService = (ItemService) ServiceFactoryImpl.getInstance()
                .getService(ServiceFactory.ServiceType.ITEM);
        return itemService.getItemsByUserId(id);
    }
    
    
}

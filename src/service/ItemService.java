package service;

import java.io.InputStream;
import java.util.ArrayList;

import model.Item;
import model.User;

public interface ItemService extends SuperService{

	String addItem(Item item, InputStream in, User seller);

	ArrayList<Item> getItemsByUserId(int id);

	String updateItem(Item item);

	String deleteItem(Item item);

	ArrayList<Item> getItemsBySearch(String category, String keywords);

	ArrayList<Item> getItemsBySearch(String keywords);

	ArrayList<Item> getItemsByCategory(String category);

	Item getItemByID(int id);

}

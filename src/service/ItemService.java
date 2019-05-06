package service;

import java.io.InputStream;
import java.util.ArrayList;

import model.item;
import model.user;

public interface ItemService extends SuperService{

	String addItem(item item, InputStream in, user seller);

	ArrayList<item> getItemsByUserId(int id);

	String updateItem(item item);

	String deleteItem(item item);

	ArrayList<item> getItemsBySearch(String category, String keywords);

	ArrayList<item> getItemsBySearch(String keywords);

	ArrayList<item> getItemsByCategory(String category);

}

package service;

import java.io.InputStream;
import java.util.ArrayList;

import model.item;
import model.user;

public interface ItemService extends SuperService{

	String addItem(item item, InputStream in, user seller);

	ArrayList getItemsByUserId(int id);

}

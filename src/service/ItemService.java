package service;

import java.io.InputStream;

import model.item;
import model.user;

public interface ItemService extends SuperService{

	String addItem(item item, InputStream in, user seller);

}

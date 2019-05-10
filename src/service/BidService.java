package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Bid;
import model.Item;

public interface BidService extends SuperService {

	String placeBid(Bid bid);

	ArrayList<Bid> getBidsByUserId(int id);
	
	ArrayList<Bid> getRecentBids();
	
	


}

package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Bid;
import util.DBConnectionUtil;

public class BidServiceImpl implements BidService {

	DBConnectionUtil db = new DBConnectionUtil();
	Connection conn = db.getDBConnection();

	
	@Override
	public void add(Object t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getByID(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(Object id, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public String placeBid(Bid bid) {
		
		int i = 0;
		String status=null;

		int itemId = bid.getItemID();
		int bidderId = bid.getBidderID();
		String msg = bid.getMessage();
		Double bidAmount = bid.getBidAmount();
		
		String query = "insert into bids values(?,?,?,?)";
		
		if(conn!=null) {
			
			
			try {
				
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, itemId);
				ps.setInt(2, bidderId);
				ps.setDouble(3, bidAmount);
				ps.setString(4, msg);
				
				i = ps.executeUpdate();
				
			
			} catch (SQLException e) {
				
			}
			
			
		}
		
		if(i!=0) {
			 status ="success";
		}
		else {
			status="Something Is Not Right!!!";
		}
		return status;
	}

	

}

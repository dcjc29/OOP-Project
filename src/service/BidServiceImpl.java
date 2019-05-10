package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Bid;
import model.Item;
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
		String id=null;
		String status=null;

		int itemId = bid.getItemID();
		int bidderId = bid.getBidderID();
		String msg = bid.getMessage();
		Double bidAmount = bid.getBidAmount();
		
		String query1 = "select max(bidId) from bids";
		String query2 = "insert into bids values(?,?,?,?,?)";
		
		if(conn!=null) {
			
			
			try {
				
				PreparedStatement pre = conn.prepareStatement(query1);
				ResultSet rs=pre.executeQuery();
				while(rs.next()) {
					
					id=rs.getString(1);
					if(id==null) {
						id="0";
					}
					
					
				}
				
				int bId=Integer.parseInt(id)+1;
				
				PreparedStatement ps = conn.prepareStatement(query2);
				ps.setInt(1, itemId);
				ps.setInt(2, bidderId);
				ps.setDouble(3, bidAmount);
				ps.setString(4, msg);
				ps.setInt(5, bId);
				
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

	@Override
	public ArrayList<Bid> getBidsByUserId(int id) {
			
		ArrayList<Bid> list=new ArrayList<Bid>();
		
		String query = "select * from bids where customerId = ?";
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Bid bid=new Bid();
					bid.setItemID(rs.getInt("itemId"));
					bid.setBidderID(rs.getInt("customerId"));
					bid.setBidAmount(rs.getDouble("bidAmount"));
					bid.setMessage(rs.getString("message"));
					
					list.add(i,bid);
					i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	public ArrayList<Bid> getRecentBids() {
		
		ArrayList<Bid> list=new ArrayList<Bid>();
		
		String query = "select * from bids order by bidId  DESC LIMIT 6";
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Bid bid=new Bid();
					bid.setItemID(rs.getInt("itemId"));
					bid.setBidderID(rs.getInt("customerId"));
					bid.setBidAmount(rs.getDouble("bidAmount"));
					bid.setMessage(rs.getString("message"));
					
					list.add(i,bid);
					i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}

	
	

}

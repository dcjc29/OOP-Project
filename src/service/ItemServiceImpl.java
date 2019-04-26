package service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.item;
import model.user;
import util.DBConnectionUtil;

public class ItemServiceImpl implements ItemService {

	@Override
	public String addItem(item item,InputStream in,user seller) {
		int i = 0;
		String id=null;
		String status=null;
		DBConnectionUtil db = new DBConnectionUtil();
		
		

		String itemTitle=item.getItemTitle();
		int noOfItem=item.getNoOfItem();
		int itemCondition=item.getItemCondition();
		String Category=item.getCategory();
		String itemDescription=item.getItemDescription();
		String itemDelivery=item.getItemDelivery();
		double minBid=item.getMinBid();
		String startDate=item.getStartDate();
		String endDate=item.getEndDate();
		int sellerId=seller.getId();
		
		Connection conn = db.getDBConnection();
		String query1 = "select max(id) from items";
		String query2 = "insert into items values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
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
				int itemId=Integer.parseInt(id)+1;

				PreparedStatement ps = conn.prepareStatement(query2);
				ps.setInt(1, itemId);;
				ps.setString(2, itemTitle);
				ps.setInt(3, noOfItem);
				ps.setInt(4, itemCondition);
				ps.setString(5, Category );
				ps.setString(6, itemDescription);
				ps.setString(7, itemDelivery);
				ps.setDouble(8, minBid);
				ps.setString(9, startDate);
				ps.setString(10, endDate);
				ps.setBlob(11, in);
				ps.setInt(12, sellerId);
				
				
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
	public Object getByID(Object id) {
	
		return null;
	}

	@Override
	public Object update(Object id, Object t) {
		
		return null;
	}

	@Override
	public void remove(Object id) {
		

	}

	@Override
	public ArrayList getAll() {
		
		return null;
	}

	@Override
	public void add(Object t) {
		
		
	}

}

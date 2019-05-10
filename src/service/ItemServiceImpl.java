package service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Blob;

import model.Item;
import model.User;
import sun.misc.BASE64Encoder;
import util.DBConnectionUtil;


public class ItemServiceImpl implements ItemService {

	DBConnectionUtil db = new DBConnectionUtil();
	Connection conn = db.getDBConnection();
	
	@Override
	public String addItem(Item item,InputStream in,User seller) {
		int i = 0;
		String id=null;
		String status=null;
	
		
		

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
	public ArrayList getItemsByUserId(int id) {
		
		
		ArrayList<Item> list=new ArrayList<Item>();
		
		String query = "select * from items where sellerId=('"+id+"')";
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Item item=new Item();
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
					item.setNoOfItem(rs.getInt("noOfItems"));
					item.setItemCondition(rs.getInt("itemsCondition"));
					item.setCategory(rs.getString("category"));
					item.setItemDescription(rs.getString("description"));
					item.setItemDelivery(rs.getString("deliveryMethod"));
					item.setMinBid(rs.getDouble("minBid"));
					item.setStartDate(rs.getString("startDate"));
					item.setEndDate(rs.getString("endDate"));
					item.setItemIn(rs.getBlob("itemImage"));
					
					list.add(i,item);
					i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	@Override
	public String deleteItem(Item item) {
		int i = 0;
		String status=null;
		int itemId=item.getItemId();
		
		String query = "DELETE FROM items where id=?";
		
		if(conn!=null) {
			
			
			try {
			
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setInt(1, itemId);
					i = ps.executeUpdate();
					
				}
				
			
			catch (SQLException e) {
				
			}
			
			
		
		
		if(i!=0) {
			 status ="success";
		}
		else {
			status="Something Is Not Right!!!";
		}
		
	}
	
		return status;
	}



	@Override
	public String updateItem(Item item) {
		
	
		int i=0;
		String status=null;
		
		int itemId=item.getItemId();
		String itemTitle=item.getItemTitle();
		int noOfItem=item.getNoOfItem();
		int itemCondition=item.getItemCondition();
		String Category=item.getCategory();
		String itemDescription=item.getItemDescription();
		String itemDelivery=item.getItemDelivery();
		double minBid=item.getMinBid();
		String startDate=item.getStartDate();
		String endDate=item.getEndDate();
		
	
		String query = "UPDATE items SET title=?,noOfItems=?,itemsCondition=?,category=?,description=?,deliveryMethod=?,minBid=?,startDate=?,endDate=? where id=?";
		
		if(conn!=null) {
			
			
			try {
			
					PreparedStatement ps = conn.prepareStatement(query);
					
					ps.setString(1, itemTitle);
					ps.setInt(2, noOfItem);
					ps.setInt(3, itemCondition);
					ps.setString(4, Category );
					ps.setString(5, itemDescription);
					ps.setString(6, itemDelivery);
					ps.setDouble(7, minBid);
					ps.setString(8, startDate);
					ps.setString(9, endDate);
					ps.setInt(10, itemId);
					
				
					i = ps.executeUpdate();
					
				}
				
			
			catch (SQLException e) {
				
			}
			
			
		
		
		if(i!=0) {
			 status ="success";
		}
		else {
			status="Something Is Not Right!!!";
		}
		
	}
	
		return status;
	}



	@Override
	public ArrayList<Item> getItemsBySearch(String category, String keywords) {
			
				ArrayList<Item> list=new ArrayList<Item>();
				
				String query = "select * from items where category=('"+category+"') AND (title LIKE('%"+keywords+"%')OR description LIKE ('%"+keywords+"%'))";
				if(conn!=null) {
					try {
						PreparedStatement ps = conn.prepareStatement(query);
						ResultSet rs=ps.executeQuery();
						int i=0;
						
						while(rs.next()) {
							Item item=new Item();
							item.setItemId(rs.getInt("id"));
							item.setItemTitle(rs.getString("title"));
							item.setNoOfItem(rs.getInt("noOfItems"));
							item.setItemCondition(rs.getInt("itemsCondition"));
							item.setCategory(rs.getString("category"));
							item.setItemDescription(rs.getString("description"));
							item.setItemDelivery(rs.getString("deliveryMethod"));
							item.setMinBid(rs.getDouble("minBid"));
							item.setStartDate(rs.getString("startDate"));
							item.setEndDate(rs.getString("endDate"));
							item.setItemIn(rs.getBlob("itemImage"));
							
							list.add(i,item);
							i++;
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				
				return list;
	}



	@Override
	public ArrayList<Item> getItemsBySearch(String keywords) {

		ArrayList<Item> list=new ArrayList<Item>();
		
		String query = "select * from items where title LIKE('%"+keywords+"%')OR description LIKE ('%"+keywords+"%')";
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
			
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Item item=new Item();
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
					item.setNoOfItem(rs.getInt("noOfItems"));
					item.setItemCondition(rs.getInt("itemsCondition"));
					item.setCategory(rs.getString("category"));
					item.setItemDescription(rs.getString("description"));
					item.setItemDelivery(rs.getString("deliveryMethod"));
					item.setMinBid(rs.getDouble("minBid"));
					item.setStartDate(rs.getString("startDate"));
					item.setEndDate(rs.getString("endDate"));
					item.setItemIn(rs.getBlob("itemImage"));
					
					list.add(i,item);
					i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}



	@Override
	public ArrayList<Item> getItemsByCategory(String category) {
	
		
		ArrayList<Item> list=new ArrayList<Item>();
		
		String query = "select * from items where category=('"+category+"')";
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Item item=new Item();
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
					item.setNoOfItem(rs.getInt("noOfItems"));
					item.setItemCondition(rs.getInt("itemsCondition"));
					item.setCategory(rs.getString("category"));
					item.setItemDescription(rs.getString("description"));
					item.setItemDelivery(rs.getString("deliveryMethod"));
					item.setMinBid(rs.getDouble("minBid"));
					item.setStartDate(rs.getString("startDate"));
					item.setEndDate(rs.getString("endDate"));
					item.setItemIn(rs.getBlob("itemImage"));
					
					list.add(i,item);
					i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}



	@Override
	public void add(Object t) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Item getItemByID(int id) {
		
		String query = "select * from items where id=('"+id+"')";
		Item item=new Item();
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {	
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
					item.setNoOfItem(rs.getInt("noOfItems"));
					item.setItemCondition(rs.getInt("itemsCondition"));
					item.setCategory(rs.getString("category"));
					item.setItemDescription(rs.getString("description"));
					item.setItemDelivery(rs.getString("deliveryMethod"));
					item.setMinBid(rs.getDouble("minBid"));
					item.setStartDate(rs.getString("startDate"));
					item.setEndDate(rs.getString("endDate"));
					item.setItemIn(rs.getBlob("itemImage"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return item;
	}

	@Override
	public ArrayList<Item> getRecentItems() {
		
		ArrayList<Item> list=new ArrayList<Item>();
		
		String query = "select * from items order by id DESC LIMIT 6";
		
		if(conn!=null) {
			
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				int i=0;
				while(rs.next()) {	
					Item item=new Item();
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
					item.setNoOfItem(rs.getInt("noOfItems"));
					item.setItemCondition(rs.getInt("itemsCondition"));
					item.setCategory(rs.getString("category"));
					item.setItemDescription(rs.getString("description"));
					item.setItemDelivery(rs.getString("deliveryMethod"));
					item.setMinBid(rs.getDouble("minBid"));
					item.setStartDate(rs.getString("startDate"));
					item.setEndDate(rs.getString("endDate"));
					item.setItemIn(rs.getBlob("itemImage"));
					list.add(i,item);
					i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
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



	@Override
	public Object getByID(Object id) {
		// TODO Auto-generated method stub
		return null;
	}




}

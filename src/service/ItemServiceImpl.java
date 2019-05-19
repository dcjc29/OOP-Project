package service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.mysql.jdbc.Blob;
import util.CommonConstants;
import util.QueryUtil;

import model.Item;
import model.User;
import sun.misc.BASE64Encoder;
import util.DBConnectionUtil;


public class ItemServiceImpl implements ItemService {

	static DBConnectionUtil db = new DBConnectionUtil();
	static Connection conn;
    private static PreparedStatement ps;
	
	static {
		createItemsTable();
	}
	

	private static void createItemsTable() {
		try {
			conn = db.getDBConnection();
			ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.CREATE_ITEM_TABLE));
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
		
	}
	
	@Override
	public String addItem(Item item,InputStream in,User seller) {
		int i = 0;
		String id=null;
		String status=null;
	
		
		

		String itemTitle=item.getItemTitle();
		int itemCondition=item.getItemCondition();
		String Category=item.getCategory();
		String itemDescription=item.getItemDescription();
		String itemDelivery=item.getItemDelivery();
		double minBid=item.getMinBid();
		String startDate=item.getStartDate();
		String endDate=item.getEndDate();
		int sellerId=seller.getId();
		
	
		
		if(conn!=null) {
			
			
			try {
				
				ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ITEM_ID_MAX));
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					id=rs.getString(1);
					if(id==null) {
						id="0";
					}
					
					
				}
				int itemId=Integer.parseInt(id)+1;

				ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_ITEM));
				ps.setInt(1, itemId);;
				ps.setString(2, itemTitle);
				ps.setInt(3, itemCondition);
				ps.setString(4, Category );
				ps.setString(5, itemDescription);
				ps.setString(6, itemDelivery);
				ps.setDouble(7, minBid);
				ps.setString(8, startDate);
				ps.setString(9, endDate);
				ps.setBlob(10, in);
				ps.setInt(11, sellerId);
				
				
				i = ps.executeUpdate();
				
			
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				
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
		
		
		if(conn!=null) {
			try {
				ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ITEMS_BY_USERID));
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Item item=new Item();
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
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
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
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
		
		
		
		if(conn!=null) {
			
			
			try {
			
					ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_ITEM));
					ps.setInt(1, itemId);
					i = ps.executeUpdate();
					
				}
				
			
			catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				
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
		int itemCondition=item.getItemCondition();
		String Category=item.getCategory();
		String itemDescription=item.getItemDescription();
		String itemDelivery=item.getItemDelivery();
		double minBid=item.getMinBid();
		String startDate=item.getStartDate();
		String endDate=item.getEndDate();
		
		
		if(conn!=null) {
			
			
			try {
			
					ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_ITEM));
					
					ps.setString(1, itemTitle);
					ps.setInt(2, itemCondition);
					ps.setString(3, Category );
					ps.setString(4, itemDescription);
					ps.setString(5, itemDelivery);
					ps.setDouble(6, minBid);
					ps.setString(7, startDate);
					ps.setString(8, endDate);
					ps.setInt(9,itemId);
					
				
					i = ps.executeUpdate();
					
				}
				
			
			catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				
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
						ps = conn.prepareStatement(query);
					
						ResultSet rs=ps.executeQuery();
						int i=0;
						
						while(rs.next()) {
							Item item=new Item();
							item.setItemId(rs.getInt("id"));
							item.setItemTitle(rs.getString("title"));
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
				ps = conn.prepareStatement(query);
			
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Item item=new Item();
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
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
				
			} catch (SQLException  e) {
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
				ps = conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					Item item=new Item();
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
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
				
			} catch (SQLException  e) {
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
		
		
		Item item=new Item();
		if(conn!=null) {
			try {
				ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ITEM_BY_ID));
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {	
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
					item.setItemCondition(rs.getInt("itemsCondition"));
					item.setCategory(rs.getString("category"));
					item.setItemDescription(rs.getString("description"));
					item.setItemDelivery(rs.getString("deliveryMethod"));
					item.setMinBid(rs.getDouble("minBid"));
					item.setStartDate(rs.getString("startDate"));
					item.setEndDate(rs.getString("endDate"));
					item.setItemIn(rs.getBlob("itemImage"));
					item.setSeller(rs.getInt("sellerId"));
				}
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
			
		}
		
		return item;
	}

	@Override
	public ArrayList<Item> getRecentItems() {
		
		ArrayList<Item> list=new ArrayList<Item>();
		
	
		
		if(conn!=null) {
			
			try {
				ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_RECENT_ITEMS));
				ResultSet rs=ps.executeQuery();
				int i=0;
				while(rs.next()) {	
					Item item=new Item();
					item.setItemId(rs.getInt("id"));
					item.setItemTitle(rs.getString("title"));
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
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
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

package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import model.User;
import util.CommonConstants;
import util.DBConnectionUtil;
import util.QueryUtil;

public class UserServiceImpl implements UserService {

	static DBConnectionUtil db;
	Connection conn = db.getDBConnection();
	
	static {
		createUsersTable();
	}
	

	private static void createUsersTable() {
		try {
			Connection connection = null;
		    Statement statement;
		    
		    statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.CREATE_USERS_TABLE));
		}catch(Exception e) {
			
		}
		
	}
	
	public ArrayList<User> getAllUsers() {

		ArrayList<User> list=new ArrayList<User>();
	
		
		
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_USERS));
			
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("uEmail"));
					user.setUserName(rs.getString("userName"));
					user.setMobileNo(rs.getString("mobileNo"));
					user.setAddress(rs.getString("addressNo")+","+rs.getString("addressStreet")+","+rs.getString("addressCity")+","+rs.getString("addressCountry"));
					user.setName(rs.getString("fName")+" "+rs.getString("lName"));
					
					list.add(i,user);
					i++;
				}
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	
	public User getUserById(int id) {

		User user = new User();
	
		
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_USER_BY_ID));
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					
					user.setId(rs.getInt("id"));
					user.setEmail(rs.getString("uEmail"));
					user.setUserName(rs.getString("userName"));
					user.setMobileNo(rs.getString("mobileNo"));
					user.setAddress(rs.getString("addressNo")+","+rs.getString("addressStreet")+","+rs.getString("addressCity")+","+rs.getString("addressCountry"));
					user.setName(rs.getString("fName")+" "+rs.getString("lName"));
				}
				
			} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
			
		}
		
		return user;
	}


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


	@Override
	public boolean updateUser(User user) {
		int i=0;
		boolean status = false;
		
		int userId=user.getId();
		String userName=user.getUserName();
		String[] name=user.getName().split(" ");
		String email=user.getEmail();
		String mobile = user.getMobileNo();
		
	
		
		
		if(conn!=null) {
			
			
			try {
			
					PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_USER));
					
					ps.setString(1, userName);
					ps.setString(2, name[0]);
					ps.setString(3, name[1]);
					ps.setString(4, email );
					ps.setString(5, mobile);
					ps.setInt(6, userId);
				
				
					i = ps.executeUpdate();
					
				}
				
			
			catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				
			}
			
			
		
		
		if(i!=0) {
			 status =true;
		}
		else {
			status=false;
		}
		
	}
	
		return status;

}


	@Override
	public int addUser(User user, byte[] salt) {
		int i = 0;
		String id=null;
		String status=null;
		int uId=0;
	
			
			String[] name = user.getName().split(" ");
			String[] address = user.getAddress().split(",");
			String uName = user.getUserName();
			String uPass = user.getUserPass();
			String mobile = user.getMobileNo();
			String userEmail = user.getEmail();
		
			
			
			
			
		
			if(conn!=null) {
				
				
				try {
					
					PreparedStatement pre = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_USER_ID_MAX));
					ResultSet rs=pre.executeQuery();
					while(rs.next()) {
						
						if(rs.getString(1)!= null) {
							id = rs.getString(1);
						}
						else {
							id = "0";
						}
						
					}
					uId=Integer.parseInt(id)+1;
					PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_USER));
					ps.setInt(1, uId);;
					ps.setString(2, uName);
					ps.setString(3, uPass);
					ps.setString(4, name[0]);
					ps.setString(5, name[1]);
					ps.setString(6, userEmail);
					ps.setString(7, address[0]);
					ps.setString(8, address[1]);
					ps.setString(9, address[2]);
					ps.setString(10, address[3]);
					ps.setString(11, mobile);
					ps.setBytes(12, salt);
			
			
					
				
					
					i = ps.executeUpdate();
					
				
				} catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
					
				}
				
			}
			
			int userId=0;
			if(i!=0) {
				 userId = uId;
			}
			
			
			return userId;
	}

	@Override
	public boolean deleteUser(int userId) {
		int i = 0;
		boolean status = false;
		
		
		
		if(conn!=null) {
			
			
			try {
			
					PreparedStatement ps = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_USER));
					ps.setInt(1, userId);
					i = ps.executeUpdate();
					
				}
				
			
			catch (SQLException | SAXException | IOException | ParserConfigurationException e) {
				
			}
			
			
		
		
		if(i!=0) {
			 status =true;
		}
		else {
			status=false;
		}
		
	}
	
		return status;
	}	

}
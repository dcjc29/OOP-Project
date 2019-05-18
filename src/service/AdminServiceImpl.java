package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item;
import model.User;
import util.DBConnectionUtil;

public class AdminServiceImpl implements AdminService {

	DBConnectionUtil db = new DBConnectionUtil();
	Connection conn = db.getDBConnection();
	
	public String addAdmin(User user, byte[] salt,int admin) {

		int i = 0;
		String id=null;
		String status=null;
	
			
			
			String uName = user.getUserName();
			String uPass = user.getUserPass();
			String mobile = user.getMobileNo();
			String userEmail = user.getEmail();
		
			
			
			String query1 = "select max(id) from admin";
			String query2 = "insert into admin values(?,?,?,?,?,?,?)";
		
			if(conn!=null) {
				
				
				try {
					
					PreparedStatement pre = conn.prepareStatement(query1);
					ResultSet rs=pre.executeQuery();
					while(rs.next()) {
						
						if(rs.getString(1)!= null) {
							id = rs.getString(1);
						}
						else {
							id = "0";
						}
						
					}
					int uId=Integer.parseInt(id)+1;
					PreparedStatement ps = conn.prepareStatement(query2);
					ps.setInt(1, uId);
					ps.setString(2, uName);
					ps.setString(3, uPass);
					ps.setString(4, userEmail);
					ps.setString(5, mobile);
					ps.setBytes(6, salt);
					ps.setInt(7, admin);
				
			
		
				
					
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
	
	
	public ArrayList<User> getAllAdmins() {

		ArrayList<User> list=new ArrayList<User>();
	
		String query = "select * from admin";
		
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
			
				ResultSet rs=ps.executeQuery();
				int i=0;
				
				while(rs.next()) {
					User admin = new User();
					admin.setId(rs.getInt("id"));
					admin.setEmail(rs.getString("email"));
					admin.setUserName(rs.getString("username"));
					admin.setMobileNo(rs.getString("mobile"));
					
					
					list.add(i,admin);
					i++;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}
	
	public User getAdminById(int id) {

		
		User admin = new User();
		String query = "select * from admin where id = ?";
		
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				
				
				while(rs.next()) {
					
					admin.setId(rs.getInt("id"));
					admin.setEmail(rs.getString("email"));
					admin.setUserName(rs.getString("username"));
					admin.setMobileNo(rs.getString("mobile"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return admin;
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
	public String updateAdmin(User admin) {
		int i=0;
		String status=null;
		
		int adminId=admin.getId();
		String userName=admin.getUserName();
		String email=admin.getEmail();
		String mobile=admin.getMobileNo();
		
		
	
		String query = "UPDATE admin SET username=?,email=?,mobile=? where id=?";
		
		if(conn!=null) {
			
			
			try {
			
					PreparedStatement ps = conn.prepareStatement(query);
					
					ps.setString(1, userName);
					ps.setString(2, email);
					ps.setString(3, mobile);
					ps.setInt(4, adminId);
				
					
				
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
	public String deleteAdmin(int adminId) {
		int i = 0;
		String status=null;
		
		String query = "DELETE FROM admin where id=?";
		
		if(conn!=null) {
			
			
			try {
			
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setInt(1, adminId);
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
	
}


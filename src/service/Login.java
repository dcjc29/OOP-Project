package service;



import java.sql.*;

import model.User;
import util.DBConnectionUtil;


public class Login{


	static ResultSet rs = null;
	static String dbName = null;
	static String dbPass = null;

	public static User login(User user) {
		
		DBConnectionUtil db = new DBConnectionUtil();
		
		Connection conn = db.getDBConnection();
		
		String username = user.getUserName();
		String password = user.getUserPass();
		
		
		String query = "select * from users where userName=? AND userPass=?";
		
		try {
			
			if(conn!=null) {
				
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			
		
			rs = ps.executeQuery();
			while(rs.next()) {
				dbName = rs.getString("userName");
				dbPass = rs.getString("userPass");
			
				if(username.equals(dbName)&& password.equals(dbPass)) {
					String fname=rs.getString("fName");
					String lname=rs.getString("lName");
					int uId = rs.getInt("id");
					
					user.setName(fname+" "+lname);
					user.setId(uId);
					
					user.setValid(true);
				}
				else {
					user.setValid(false);
				}
			}
			
			}	
		}catch(Exception e) {
			System.out.println("Login Failed! "+e);
		}
		finally {
			
			if(rs!=null) {
				try {
					rs.close();
				}catch(Exception e) {}
				rs=null;
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(Exception e) {
					conn = null;
				}
			}
		}
	return user;
	}

	public static byte[] getSalt(String userName) {
		byte[] userSalt = null;
		DBConnectionUtil db = new DBConnectionUtil();
		Connection conn = db.getDBConnection();
		String query = "select * from users where userName=?";
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, userName);
				rs = ps.executeQuery();
				while(rs.next()) {
					userSalt=rs.getBytes(12);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		return userSalt;
	}
	
}
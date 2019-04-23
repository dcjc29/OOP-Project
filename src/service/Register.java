package service;

import java.sql.*;
import model.user;
import util.DBConnectionUtil;

public class Register {

	public static String register(user user) {
			
		int i = 0;
		String id=null;
		String status=null;
		DBConnectionUtil db = new DBConnectionUtil();
			
			String[] name = user.getName().split(" ");
			String[] address = user.getAddress().split(",");
			String uName = user.getUserName();
			String uPass = user.getUserPass();
			String mobile = user.getMobileNo();
			String userEmail = user.getEmail();
		
			
			Connection conn = db.getDBConnection();
			String query1 = "select max(id) from users";
			String query2 = "insert into users values(?,?,?,?,?,?,?,?,?,?,?)";
		
			if(conn!=null) {
				
				
				try {
					
					PreparedStatement pre = conn.prepareStatement(query1);
					ResultSet rs=pre.executeQuery();
					while(rs.next()) {
						
						id=rs.getString(1);
						
					}
					int uId=Integer.parseInt(id)+1;
					PreparedStatement ps = conn.prepareStatement(query2);
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

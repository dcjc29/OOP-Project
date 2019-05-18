package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import util.DBConnectionUtil;

public class UserServiceImpl implements UserService {

	DBConnectionUtil db = new DBConnectionUtil();
	Connection conn = db.getDBConnection();
	
	public ArrayList<User> getAllUsers() {

		ArrayList<User> list=new ArrayList<User>();
	
		String query = "select * from users";
		
		if(conn!=null) {
			try {
				PreparedStatement ps = conn.prepareStatement(query);
			
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

}

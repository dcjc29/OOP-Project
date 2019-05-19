package util;

import java.io.*;
import java.sql.*;
import java.util.Properties;


public class DBConnectionUtil extends CommonUtil{
	static InputStream in = null;
	static String msg = null;
	private static Connection con;
	public static final Properties props = new Properties();
	

	private DBConnectionUtil(){
		
	}
	public static Connection getDBConnection(){
		
	try
	{
		if (con == null || con.isClosed()) {

			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			con = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
		}
		
	
	}catch(Exception e) {
		 msg=e.toString();
		
	}
	return con;
	}
	

}

	



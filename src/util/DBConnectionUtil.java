package util;

import java.io.*;
import java.sql.*;
import java.util.Properties;


public class DBConnectionUtil{
	static InputStream in = null;
	
	private static Connection con;
	public static final Properties props = new Properties();
	

	public  Connection getDBConnection(){
		
	try
	{
		//File inFile = new File("/BidWars/src/util/config.properties");
		String propname = "config.properties";
		in=getClass().getResourceAsStream(propname);
		if(in!=null) {
		props.load(in);
		}

		String driver = props.getProperty("driverName");
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		

		if (driver != null) {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
	}
	
	}catch(Exception e) {
		String msg=e.toString();
		
	}
	return con;
	}
	

}

	



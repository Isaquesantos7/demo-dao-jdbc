package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	static Connection conn = null;
	
	//starts connection
	public static Connection getConnection() {
		try {
			if(conn == null) {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			return conn;
		}
		catch(SQLException e)
		{
			throw new DbExceptions("Error: " + e.getMessage());
		}
	}
	
	//close connection
	public static void closeConnection() {
		if(conn != null) {
			try 
			{
				conn.close();
			}
			catch(SQLException e)
			{
				throw new DbExceptions("Error: " + e.getMessage());
			}
		}
	}
	
	//close Statement
	public static void closeStatement(Statement st) {
		if(st != null) 
		{
			try
			{
				st.close();
			}
			catch(SQLException e)
			{
				throw new DbExceptions("Error: " + e.getMessage());
			}
		}
	}
	
	//close ResultSet
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) 
		{
			try
			{
				rs.close();
			}
			catch(SQLException e)
			{
				throw new DbExceptions("Error: " + e.getMessage());
			}
		}
	}
	
	//loading properties
	private static Properties loadProperties() {
		try(FileInputStream sf = new FileInputStream("db.properties"))
		{
			Properties props = new Properties();
			props.load(sf);
			return props;
		}
		catch(IOException e) 
		{
			throw new DbExceptions("Error: " + e.getMessage());
		}
	}
}

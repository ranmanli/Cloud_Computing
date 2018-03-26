package lab1;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class LoginImpl{
	
	public Map userLogin(String username, String password) {
		//connect database
		Connection c = null;
		Statement stmt = null;
		Map map = new HashMap();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:userInfo.db");
			System.out.println("opened database successfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM LOGIN_INFO where (USERNAME = '"
					+ username
					+ "'"
					+ "and PASSWORD = '"
					+ password
					+ "');";
			ResultSet rs = stmt.executeQuery(sql);
			
			boolean result = false; 
			if (rs.next()) {
				System.out.println("\nthe data in login_info table are as below");
				System.out.println("id\tusername\t\tpassword");
				int id = rs.getInt("ID");
				String user = rs.getString("USERNAME");
				String pass = rs.getString("PASSWORD");
				System.out.println(id+"\t"+user+"\t"+pass);
				System.out.println("log in successfully");
				result = true;
			}
			map.put("result", result);
			
			rs.close();
			stmt.close();
			c.close();
			
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName() + ":  " + e.getMessage());
		    System.exit(0);
		}
		//check the info
		
		//return the result
		return map;
	}
	public static void printRS (ResultSet rs){ 
		System.out.println("\nthe data in login_info table are as below");
		System.out.println("id\tusername\t\tpassword");
		try {
			while (rs.next()) {
				int id = rs.getInt("ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				System.out.println(id+"\t"+username+"\t"+password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("error while printing the result set---"+e.getMessage());
			e.printStackTrace();
		}
	}
}

package lab1;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class LoginImpl implements Login{
	public Map userLogin(String username, String password)throws RemoteException{
		//connect database
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:userInfo.db");
			System.out.println("opened database successfully");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM LOGIN_INFO where USERNAME = '"
					+ username
					+ "';";
			ResultSet rs = stmt.executeQuery(sql);
			printRS(rs);
			
			/*
			 * prepare for the detailed feedback
			 */
			Map map = new HashMap();
			boolean result = false; 
			map.put("result", result);
			
			rs.close();
			stmt.close();
			c.close();
			
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName() + ":  " + e.getMessage());
		    System.exit(0);
		}
		
		return null;
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

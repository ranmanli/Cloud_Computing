package lab1;


import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class RegisterImpl{

	public Map registerNewUser(String username, String password) {
		//start connection to database here
		Connection c = null;
		Statement stmt =  null;
		Map map = new HashMap();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:userInfo.db");
			
			stmt = c.createStatement();
			String sql = "SELECT * FROM LOGIN_INFO where (USERNAME = '"
					+ username
					+ "');";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				map.put("result", false);
				map.put("faultMessage", "The Username was already existed!");
				return map;
			}
			sql = "INSERT INTO LOGIN_INFO (USERNAME, PASSWORD) VALUES ('"
					+ username
					+ "','"
					+ password
					+ "');";
			int affectRow = stmt.executeUpdate(sql);
			
			boolean result = false; 
			if(affectRow == 1) {
				result = true;
			}
			map.put("result", result);
			
			stmt.close();
			c.close();
			
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage());
			map.put("result", false);
			return map;
		}
		System.out.println("Opened database successfully");
		//insert user info into database
		
		//return the results 
		return map;
	}
}

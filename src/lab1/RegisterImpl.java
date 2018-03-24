package lab1;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class RegisterImpl implements Register{
	public Map registerNewUser(String username, String password)
					throws RemoteException{
		//start connection to database here
		Connection c = null;
		Statement stmt = null;
		Map map = new HashMap();
		boolean result = false; 
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:userInfo.db");
			System.out.println("opened database successfully");
			
			stmt = c.createStatement();

			String sql = "INSERT INTO LOGIN_INFO (USERNAME, PASSWORD)"
					+ "VALUES ('"
					+ username
					+ "','"
					+ password
					+ "');";
			int affectNum = stmt.executeUpdate(sql);
			System.out.println("the number of affected line is: "+affectNum);
			
			sql = "SELECT * FROM LOGIN_INFO;";
			ResultSet rs = stmt.executeQuery(sql);
			LoginImpl.printRS(rs);
			
			if (affectNum == 1) {
				result = true;
			}
			
			rs.close();
			stmt.close();
			c.close();
		}
		catch(Exception e) {
			System.err.println( e.getClass().getName() + ":  " + e.getMessage());
		    System.exit(0);
		}
		map.put("result", result);
		return map;
	}
}

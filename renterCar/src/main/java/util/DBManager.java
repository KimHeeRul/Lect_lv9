package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	private DBManager() {
		
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/rentCar?serverTimeZone=UTC";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
			
			if (conn != null) {
				System.out.println("DB연결성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

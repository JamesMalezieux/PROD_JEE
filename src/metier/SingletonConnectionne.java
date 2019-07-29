package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnectionne {
	private static Connection connection;
	static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:8888/CATPROD", "root", "0000");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public static Connection getConnection() {
		return connection;
	}
	
}

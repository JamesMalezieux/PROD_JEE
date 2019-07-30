package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnectionne {

	private static Connection connection;
	static {
		System.out.println("Connection à la base de données.");
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		System.out.println("Driver OK");
		String url ="jdbc:mysql://localhost:8889/CAT_PROD?serverTimezone=UTC&autoReconnect=true&useSSL=false";
		
		
		connection=DriverManager.getConnection(url, "wakidaisho", "");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Chargement driver NOK");
		e.printStackTrace();
	}
	
	}
	public static Connection getConnection() {
		return connection;
	}
	
}

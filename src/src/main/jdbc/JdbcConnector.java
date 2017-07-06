package src.main.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnector {
	public static final String CONNECT_URL = "jdbc:mysql://localhost";
	public static final String SSL_OPTION = "?autoReconnect=true&useSSL=false";
	public static final String CONNECT_ID = "brain";
	public static final String CONNECT_PASSWORD = "104070";
	
	public Connection connection = null;
	
	public void connect() {
		try {
			connection = DriverManager.getConnection(CONNECT_URL + SSL_OPTION, CONNECT_ID, CONNECT_PASSWORD);
			System.out.println("Jdbc connection success!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void showDbs() {
		java.sql.Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SHOW DATABASES");
			
			if(resultSet != null) {
				while(resultSet.next()) {
					String str = resultSet.getNString(1);
					System.out.println(str);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

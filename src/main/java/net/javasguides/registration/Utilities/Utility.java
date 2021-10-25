package net.javasguides.registration.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility
{
	private static String username = "root";
	private static String password = "root";
	public static Connection getConnection()
	{
		Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?allowPublicKeyRetrieval=true&useSSL=false & serverTimezone=UTC", username, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
		
	}
}
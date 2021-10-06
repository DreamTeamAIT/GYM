package net.javasguides.registration.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.javasguides.registration.model.Customer;
import sun.security.mscapi.CKeyPairGenerator.RSA;

public class CustomerDao {
	//We want to make sure we don't have duplicate emails or passwords. This code checks for that by counting how many 
	// duplicates of the new email and password we get and returns an appropiate error message.
	public String checkCustomer(Customer customer) throws ClassNotFoundException
	{
		
		String DUPLICATE_EMAIL_SQL = "SELECT COUNT(*) FROM customer where email = " + customer.getEmail() + ";" ;
		String DUPLICATE_PASSWORD_SQL = "SELECT COUNT(*) FROM customer where password = " + customer.getPassword() + ";" ;
		
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/mysql_database?allowPublicKeyRetrieval=true&useSSL=false & serverTimezone=UTC", "root", "geochelone");

	            PreparedStatement emailPreparedStatement = connection.prepareStatement(DUPLICATE_EMAIL_SQL);
	            		PreparedStatement passwordPreparedStatement = connection.prepareStatement(DUPLICATE_EMAIL_SQL)) {
	            System.out.println(emailPreparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet result = emailPreparedStatement.executeQuery();
	            int count = result.getInt(0);
	            if(count >= 0)
	            {
	            	return "Duplicate Email";
	            }
	            else
	            {
	           
	    	            System.out.println(passwordPreparedStatement);
	    	            // Step 3: Execute the query or update query
	    	            result = passwordPreparedStatement.executeQuery();
	    	            count = result.getInt(0);
	    	            if(count >= 0)
	    	            {
	    	            	return "Duplicate Password";
	    	            }
	    	            else
	    	            {
	    	            	return "No duplicates.";
	    	            }
	            }
	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	            return "Connection Error";
	        }
	}
    public int registerCustomer(Customer customer) throws ClassNotFoundException {
    	
        String INSERT_USERS_SQL = "INSERT INTO customer" +
            "  (id, first_name, last_name, password, email) VALUES " +
            " (?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database?allowPublicKeyRetrieval=true&useSSL=false & serverTimezone=UTC", "root", "geochelone");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setString(5, customer.getEmail());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

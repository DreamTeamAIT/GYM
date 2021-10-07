package net.gym.classes.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.gym.classes.*;
import net.gym.classes.model.Classes;
import net.gym.login.model.Login;

public class ClassDao {

	public int registerClass(Classes classes) throws ClassNotFoundException {
      
        String INSERT_CLASSES_SQL = "INSERT INTO classes" +
                "  (classname, instructor, classtime) VALUES " +
                " ( ?, ?, ?);";
        
        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/gym?useSSL=false", "root", "admin");

        		// Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLASSES_SQL)) {
                
        	 	//preparedStatement.setInt(1, 1);
                preparedStatement.setString(1, classes.getClassname());
                preparedStatement.setString(2, classes.getInstructor());
                preparedStatement.setString(3, classes.getClasstime());
               
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
                //ResultSet resultSet = preparedStatement.getGeneratedKeys();
                //resultSet.next();
                //int classID = resultSet.getInt(1);
        		//classes.setClassID(classID);

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

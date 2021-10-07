package net.gym.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.gym.login.model.Instructor;
import net.gym.login.model.Login;

public class InstructorDao {
	public boolean validate(Instructor instructor) throws ClassNotFoundException {
       

        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("insert into instructor(name,gender) values(?,?);")) {
            preparedStatement.setString(1, instructor.getName());
            preparedStatement.setString(2, instructor.getGender());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            // process sql exception
//            printSQLException(e);
        	System.out.println();
        }
        finally {
        	
        }
        return false;
        
}
}

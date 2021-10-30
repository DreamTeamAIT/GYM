package net.gym.login.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.gym.login.model.Instructor;

public class InstructorDao {
	public boolean validate(Instructor instructor) throws ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

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
		} finally {

		}
		return false;

	}
	
	
	
	
	
	
	public boolean deleteTodo(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DriverManager.getConnection(
        		"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");
        		PreparedStatement preparedStatement = connection.prepareStatement("delete from gym.instructor where id = ?;")) {
        		preparedStatement.setInt(1, id);
            	rowDeleted = preparedStatement.execute();
        }
        return rowDeleted;
    }

	
	public boolean updateTodo(Instructor instructor) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");
        		PreparedStatement preparedStatement = connection.prepareStatement("update gym.instructor set name = ?, gender= ? where id = ?;")) {
        	preparedStatement.setInt(3, instructor.getId());
        	preparedStatement.setString(2, instructor.getGender());
        	preparedStatement.setString(1, instructor.getName());
            rowUpdated = preparedStatement.execute();
        }
        return rowUpdated;
    }
	
	
	
	
	
	
	public List<Instructor> queryInstructor() throws ClassNotFoundException {
		List<Instructor> instructorList = new ArrayList();

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM gym.instructor;")) {

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Instructor instructor = new Instructor();
				instructor.setId(id);
				instructor.setGender(gender);
				instructor.setName(name);
				instructorList.add(instructor);

			}

		} catch (SQLException e) {
			// process sql exception
//            printSQLException(e);
			System.out.println();
		} finally {

		}
		return instructorList;

	}
	
	
	public Instructor queryInstructor(int id) throws ClassNotFoundException {
		Instructor instructor = new Instructor();
		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/gym?allowPublicKeyRetrieval=true&useSSL=false", "root", "root");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM gym.instructor where id=?;")) {

			System.out.println(preparedStatement);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String gender =rs.getString("gender");
				instructor.setId(id);
				instructor.setName(name);
				instructor.setGender(gender);
			}

		} catch (SQLException e) {
			// process sql exception
//            printSQLException(e);
			System.out.println();
		} finally {

		}
		return instructor;

	}

}

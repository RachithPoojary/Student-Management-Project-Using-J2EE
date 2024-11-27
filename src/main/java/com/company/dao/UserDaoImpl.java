package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.util.DBUtil;

public class UserDaoImpl implements UserDao{
	 @Override
	    public boolean isValidUser(String email, String password) {
	        String query = "SELECT * FROM users WHERE email = ? AND password = ? ";
	    	 try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, email);
	            preparedStatement.setString(2, password);
//	            preparedStatement.setString(3, username);
	            

	            ResultSet resultSet = preparedStatement.executeQuery();
//	            System.out.println("Query run hogayi");	
	            return resultSet.next();
	            
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	 @Override
	    public boolean addUser(User user) {
	        String query = "INSERT INTO users (username, email,phone,std, password) VALUES (?,  ? , ?, ?, ?)";

	        try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPhone());
	            preparedStatement.setString(4, user.getStd());
	            preparedStatement.setString(5, user.getPassword());

	            int rowsAffected = preparedStatement.executeUpdate();

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	 @Override public User getUserByEmail(String email) { 
		 User user = null;
		 try {
			 Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectDB", "postgres", "root"); 
			 String query = "SELECT * FROM users WHERE email = ?"; 
			 PreparedStatement ps = con.prepareStatement(query); 
			 ps.setString(1, email); 
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) { 
				 user = new User(); 
				 user.setUsername(rs.getString("username")); 
				 user.setEmail(rs.getString("email")); 
				 user.setPhone(rs.getString("phone")); 
				 user.setStd(rs.getString("std")); 
				 user.setPassword(rs.getString("password"));
				 } } 
		 catch (SQLException e) {
			 e.printStackTrace(); }
		 return user; }

}

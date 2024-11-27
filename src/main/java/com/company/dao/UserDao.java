package com.company.dao;

public interface UserDao {

	boolean isValidUser(String email, String password);
	User getUserByEmail(String email);

	boolean addUser(User user);


}

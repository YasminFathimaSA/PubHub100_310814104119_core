package com.revature.bookapp.test;

import com.revature.bookapp.dao.UserDAO;
import com.revature.bookapp.model.UserModel;

public class TestUserDAO {
	public static void main(String[] args) throws Exception
	{
		UserModel user=new UserModel();
		user.setUsername("qw ");
		user.setPassword("2042");
		System.out.println(user.getId()+user.getUsername()+user.getPassword());
		UserDAO dao=new UserDAO();
		dao.register(user);
		dao.login(user);
	}
}

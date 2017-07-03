package com.revature.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bookapp.model.UserModel;
import com.revature.bookapp.util.ConnectionUtil;


public class UserDAO {
	public void register (UserModel user) {
    	Connection connection= ConnectionUtil.getConnection();
    	PreparedStatement pst;
		try {
			pst = connection.prepareStatement("INSERT INTO USERS (username,password) values (?,?)");
			pst.setString(1,user.getUsername());
	        pst.setString(2, user.getPassword());
	        pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
}
    public boolean login(UserModel user) {
    	Connection connection= ConnectionUtil.getConnection();
    	 boolean flag=false;
    	PreparedStatement pst;
		try {
			pst = connection.prepareStatement("select username from  users where username=? and password=?");
			pst.setString(1,user.getUsername());
	    	pst.setString(2,user.getPassword());
	        ResultSet rs=pst.executeQuery();
	       
	        if(rs.next())
	        {  
	        	flag=true;	
	        }   	        
		} catch (SQLException e) {
			e.printStackTrace();
		}		  
		 return flag; 
    }
   
}

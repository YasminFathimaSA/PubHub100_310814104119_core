package com.revature.bookapp.util;

import java.sql.Connection;


public class TestConnectionUtil {
	public static void main(String[]args)throws Exception

	{  
		Connection conn=ConnectionUtil.getConnection();
		System.out.println(conn);
		
	}
}

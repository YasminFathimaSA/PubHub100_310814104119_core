package com.revature.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bookapp.model.BookModel;
import com.revature.bookapp.util.ConnectionUtil;



public class BookDAO {
	public void save(BookModel book)
	{
		Connection connection= ConnectionUtil.getConnection();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("INSERT INTO BOOKS (name,price) values (?,?)");
			pst.setString(1,book.getName());
		    pst.setInt(2,book.getPrice());
		    pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateName(BookModel book) 
	{
		Connection connection= ConnectionUtil.getConnection();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("UPDATE BOOKS SET NAME=? WHERE ID=?");
			pst.setString(1,book.getName());
		    pst.setInt(2,book.getId());
		    pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

	public void updatePrice(BookModel book) 
	{
		Connection connection= ConnectionUtil.getConnection();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("UPDATE BOOKS SET PRICE=? WHERE ID=?");
			pst.setInt(1,book.getPrice());
		    pst.setInt(2,book.getId());
		    pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void removeById(int id)
	{

		Connection connection= ConnectionUtil.getConnection();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("DELETE FROM BOOKS WHERE ID=?");
			 pst.setInt(1,id);
			    pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}



	public void removeByName(String name)
	{

		Connection connection= ConnectionUtil.getConnection();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("DELETE FROM BOOKS WHERE NAME=?");
			pst.setString(1,name);
		    pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void removeByPrice(int price)
	{

		Connection connection= ConnectionUtil.getConnection();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("DELETE FROM BOOKS WHERE PRICE=?");
			pst.setInt(1,price);
		    pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	;
	}


	public void removeAll(BookModel book)
	{

		Connection connection= ConnectionUtil.getConnection();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("TRUNCATE BOOKS");
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public List<BookModel> findAll()
	{
		Connection connection= ConnectionUtil.getConnection();
		PreparedStatement pst;
		List<BookModel> books=new ArrayList<>();
		try {
			pst = connection.prepareStatement("SELECT ID,NAME,PRICE FROM BOOKS");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			BookModel book=new BookModel();	
			book.setId(rs.getInt(1));
			book.setName(rs.getString(2));
			book.setPrice(rs.getInt(3));
			books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	
	public List<BookModel> findByName(String name)
	{
		Connection connection= ConnectionUtil.getConnection();
		PreparedStatement pst;
		List<BookModel> books=new ArrayList<>();
		try {
			pst = connection.prepareStatement("SELECT ID,NAME,PRICE FROM BOOKS WHERE NAME=?");
			pst.setString(1,name);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
			BookModel book=new BookModel();	
			book.setId(rs.getInt(1));
			book.setName(rs.getString(2));
			book.setPrice(rs.getInt(3));
			System.out.println(book);
			books.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
}

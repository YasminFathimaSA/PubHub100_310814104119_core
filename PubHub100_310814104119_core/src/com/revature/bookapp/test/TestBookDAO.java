package com.revature.bookapp.test;

import com.revature.bookapp.dao.BookDAO;
import com.revature.bookapp.model.BookModel;

public class TestBookDAO {
	public static void main(String args[]) throws Exception
	{
		BookModel book=new BookModel();
		book.setId(1);
		book.setName("java1");
		book.setPrice(230);
	    BookDAO dao=new BookDAO();
        dao.save(book);
        dao.updateName(book);
	    dao.updatePrice(book);
	    dao.removeById(book.getId());
	    dao.removeByName(book.getName());
        dao.removeByPrice(book.getPrice());
        dao.removeAll(book);
	    dao.findAll();
	    dao.findByName(book.getName());
	 	
	}
}

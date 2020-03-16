package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BookInventory;
import com.capgemini.librarymanagementsystem.beans.BookRegistration;
import com.capgemini.librarymanagementsystem.beans.BookTransaction;
import com.capgemini.librarymanagementsystem.beans.UserBean;

public interface UserDao {
	
	public UserBean login(String userEmail,String password);
	public boolean changePassword(int userId,String password);
	//public boolean forgotPassword(int user,String password);
	public List<BookInventory> searchBookByName(String bookName);
	public BookRegistration requestBook(int bookId);
	//public UserBean returnBook(BookInventory bookId, BookTransaction returnDate);
	public List<BookInventory> viewAllBooks();

}

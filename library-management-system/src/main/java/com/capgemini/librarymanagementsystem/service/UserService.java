package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BookInventory;
import com.capgemini.librarymanagementsystem.beans.BookRegistration;
import com.capgemini.librarymanagementsystem.beans.UserBean;

public interface UserService {

	public UserBean login(String userEmail, String password);

	public boolean changePassword(int userId, String password);

	// public boolean forgotPassword(int user,String password);
	public List<BookInventory> searchBookByName(String bookName);

	public BookRegistration requestBook(int userId);

	// public UserBean returnBook(BookInventory bookId, BookTransaction returnDate);
	public List<BookInventory> viewAllBooks();

}

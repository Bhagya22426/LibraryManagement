package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BookInventory;
import com.capgemini.librarymanagementsystem.beans.BookRegistration;
import com.capgemini.librarymanagementsystem.beans.UserBean;
import com.capgemini.librarymanagementsystem.dao.UserDao;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public UserBean login(String userEmail, String password) {
		return dao.login(userEmail, password);
	}

	@Override
	public boolean changePassword(int userId, String password) {
		return dao.changePassword(userId, password);
	}

	@Override
	public List<BookInventory> searchBookByName(String bookName) {
		return dao.searchBookByName(bookName);
	}

	@Override
	public BookRegistration requestBook(int bookId) {
		return dao.requestBook(bookId);
	}

	@Override
	public List<BookInventory> viewAllBooks() {
		return dao.viewAllBooks();
	}
	
	
}

package com.capgemini.librarymanagementsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.BookInventory;
import com.capgemini.librarymanagementsystem.beans.BookRegistration;
import com.capgemini.librarymanagementsystem.beans.LibraryResponse;
import com.capgemini.librarymanagementsystem.beans.UserBean;
import com.capgemini.librarymanagementsystem.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService service;
	
	@PostMapping(path = "/login",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse login(@RequestBody UserBean bean) {
		UserBean infoBean = service.login(bean.getUserEmail(), bean.getPassword());
		LibraryResponse response = new LibraryResponse();
		if (infoBean!=null) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("Valid User Credentials");
			response.setBeans(Arrays.asList(infoBean));
		} else {
			response.setStatusCode(401);
			response.setMessage("FAILURE");
			response.setDescription("Invallid Credentials");
		}
		return response;
	}
	
	@PutMapping(path = "/changePassword",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse changePassword(@RequestBody UserBean bean) {
		LibraryResponse response = new LibraryResponse();
		if (service.changePassword(bean.getUserId(), bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("Successfully changed the password");
		} else {
			response.setStatusCode(401);
			response.setMessage("FAILURE");
			response.setDescription("Unable change the password");
		}
		return response;
	}
	
	@GetMapping(path = "/requestBook/{bookId}",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse requestBook(@PathVariable  ("bookId") int bookId) {
		LibraryResponse response = new LibraryResponse();
		BookRegistration register = service.requestBook(bookId);
		if (register!=null) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("RequestedBook found from the database");
		} else {
			response.setStatusCode(401);
			response.setMessage("FAILURE");
			response.setDescription("Book not found");
		}
		return response;
	}
	@GetMapping(path = "/searchBookByName{bookName}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse registerUser(@PathVariable("bookName") String bookName) {
		LibraryResponse response = new LibraryResponse();
		List<BookInventory> bean = service.searchBookByName(bookName);
		if (bean != null) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("User added to database");
			} else {
				response.setStatusCode(401);
				response.setMessage("FAILURE");
				response.setDescription("User not added to the database");
				
		}
		return response;
	}
	
	@GetMapping(path = "/viewAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryResponse viewAllBooks() {
		LibraryResponse response = new LibraryResponse();
		List<BookInventory> bean = service.viewAllBooks();
		if (bean != null && !bean.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("SUCCESS");
			response.setDescription("Viewed all the Books");
			response.setBook(bean);
		} else {
			response.setStatusCode(401);
			response.setMessage("FAILURE");
			response.setDescription("Unable to view the books");
		}
		return response;
	}


}

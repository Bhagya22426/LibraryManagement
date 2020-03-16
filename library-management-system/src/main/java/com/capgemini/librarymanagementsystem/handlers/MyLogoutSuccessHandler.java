package com.capgemini.librarymanagementsystem.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.capgemini.librarymanagementsystem.beans.LibraryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		LibraryResponse libraryResponse = new LibraryResponse();
		libraryResponse.setStatusCode(201);
		libraryResponse.setMessage("SUCCESS");
		libraryResponse.setDescription("You have successfully Logout");
		
		response.setStatus(200);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		ObjectMapper mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(libraryResponse));
	}
	
	

}

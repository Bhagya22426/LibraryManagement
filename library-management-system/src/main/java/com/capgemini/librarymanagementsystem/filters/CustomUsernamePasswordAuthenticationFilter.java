package com.capgemini.librarymanagementsystem.filters;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.capgemini.librarymanagementsystem.beans.UserBean;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private UserBean userBean;


	@Override
	protected String obtainPassword(HttpServletRequest request) {
		if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			userBean = null;
			try {
				UserBean user = getUserInfo(request);
				return user.getPassword();
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		return super.obtainPassword(request);
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
			try {
				UserBean infoBean = getUserInfo(request);
				return infoBean.getUserName();
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		return super.obtainUsername(request);
	}

	private UserBean getUserInfo(HttpServletRequest request) throws IOException {
		if (userBean != null) {
			ObjectMapper mapper = new ObjectMapper();
			String json = "";
			BufferedReader reader = request.getReader();
			while (reader.ready()) {
				json = json + reader.readLine();
			}
			userBean = mapper.readValue(json, UserBean.class);
		}
		return userBean;

	}

}

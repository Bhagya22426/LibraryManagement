package com.capgemini.librarymanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.capgemini.librarymanagementsystem.dao.AdminDao;
import com.capgemini.librarymanagementsystem.security.UserDetailsImpl;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private AdminDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
		userDetailsImpl.setUserBean(dao.getUserByName(username));
		return userDetailsImpl;
	}

}

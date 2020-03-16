package com.capgemini.librarymanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.capgemini.librarymanagementsystem.filters.CustomUsernamePasswordAuthenticationFilter;
import com.capgemini.librarymanagementsystem.handlers.MyLogoutSuccessHandler;
import com.capgemini.librarymanagementsystem.security.LibrarySystemAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class LibraryManagementSystemSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private LibrarySystemAuthenticationEntryPoint libraryAuthenticationEntryPoint;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
	private MyLogoutSuccessHandler myLogoutSuccessHandler;

	@Bean
	public UsernamePasswordAuthenticationFilter getUsernamePasswordAuthenticationFilter() throws Exception {
		CustomUsernamePasswordAuthenticationFilter filter = new CustomUsernamePasswordAuthenticationFilter();
		filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		filter.setAuthenticationFailureHandler(authenticationFailureHandler);
		filter.setAuthenticationManager(authenticationManager());
		return filter;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.exceptionHandling()
		.authenticationEntryPoint(libraryAuthenticationEntryPoint)
		.and()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/changePassword").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/searchBookByName").hasRole("USER")
		.and()
		.authorizeRequests()
		.antMatchers("/requestBook").hasRole("USER")
		.and()
		.authorizeRequests()
		.antMatchers("/viewAllBooks").hasRole("USER")
		.and()
		.authorizeRequests()
		.antMatchers("/registerStudent").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/updateStudent").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/auth").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/deleteStudent").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/getStudentById").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/showAllStudents").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/addBook").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/updateBook").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/deleteBook").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/getBookByName").hasRole("ADMIN")
		.and()
		.authorizeRequests()
		.antMatchers("/showAllBooks").hasRole("ADMIN")
		.and()
		.addFilterBefore(getUsernamePasswordAuthenticationFilter(), CustomUsernamePasswordAuthenticationFilter.class)
		.logout()
		.logoutSuccessHandler(myLogoutSuccessHandler);
		
	}
	
	
}

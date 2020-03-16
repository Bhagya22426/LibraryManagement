package com.capgemini.librarymanagementsystem.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="User_Details")
public class UserBean implements Serializable{
	
	@Id
	@Column
	@GeneratedValue
	private int userId;
	@Column
	private String userName;
	@Column
	private String userEmail;
	@Column
	private String password;
	@Column
	private String userType;
	@Column
	private long mobileNo;
	
	
	 
//	@Exclude
//	@JsonIgnore
//	@OneToMany(cascade=CascadeType.ALL,mappedBy = "user")
//	private Collection<BookInventory> bookInvent;
//	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userInfo")
//	private Collection<BookTransaction> transaction;
	
	

}

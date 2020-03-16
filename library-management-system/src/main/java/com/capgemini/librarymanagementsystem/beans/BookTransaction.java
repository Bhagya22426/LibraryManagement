package com.capgemini.librarymanagementsystem.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="Book_Transaction")
public class BookTransaction implements Serializable{
	
	@Id
	@Column
	@GeneratedValue
	private String transactionId;
	@Column
	private int registrationId;
	@Column
	private long fine;
	@Column
	private int bookId;
	@Column
	private int issueId;
	@Column
	private Date issueDate;
	@Column
	private Date returnDate;
	
//	@Exclude
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	private UserBean userInfo;
//
//	@JsonIgnore
//	@ManyToOne(cascade = CascadeType.ALL)
//	private BookInventory bookInvent;
	
}

package com.capgemini.librarymanagementsystem.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="Book_Inventory")
public class BookInventory implements Serializable{

	@Id
	@GeneratedValue
	@Column
	private int bookId;
	@Column
	private String bookName;
	@Column
	private String author1;
	@Column
	private String author2;
	@Column
	private String publisher;

//	@Exclude
//	@JsonIgnore
//	@ManyToOne(cascade=CascadeType.ALL)
//	private UserBean user;
//	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bookInvent")
//	private Collection<BookTransaction> transaction;
	
}

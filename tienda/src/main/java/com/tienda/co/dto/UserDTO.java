package com.tienda.co.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO  implements Serializable{	

	private static final long serialVersionUID = 1L;
	private Long id;
	private String user;
	private String pass;	
	private Date dateCreation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	 
}

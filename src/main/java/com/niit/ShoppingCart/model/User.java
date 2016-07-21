package com.niit.ShoppingCart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name= "user")
@Component

public class User {

	
	@Id
	private String id;

	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile")
	private String mobile;// in h2 db for mobile, i had given it as varchar2 datatype (lets try it with Integer else String)
	
	@Column(name="e_mail")
	private String e_mail;
	
	@Column(name="address")
	private String address;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}

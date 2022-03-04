package com.user.userapi;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	private String phone;
	private String city;
	

	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(Long id, String userName, String phone, String city) {
		this.id = id;
		this.userName = userName;
		this.phone = phone;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}

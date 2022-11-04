package com.socialmediapage.digipage.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	@Column
	 private String name;
	 @Column
	 private String email;
	 @Column
	 private String phoneNumber;
	 @Column
	 private String password;
	public Admin(int id, String name, String email, String phoneNumber, String password) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin() {
		
	}
	 
}
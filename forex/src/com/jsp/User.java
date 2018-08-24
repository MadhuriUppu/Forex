package com.jsp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="client")
@Table(name="client")
public class User {
	
	@Id
	@Column(name="cid")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int client_id;
	
	@Column(name="name")
	String username;
	
	@Column(name="password")
	String password;
	
	@Column(name="email")
	String emailId;
	
	@Column(name="phone")	
	int phoneNo;

	@Column(name="bank_acc")
	int BankNo;
	
	public User() {}

	public int getClientId() {
		return client_id;
	}

	public void setClientId(int clientId) {
		this.client_id = clientId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getBankNo() {
		return BankNo;
	}

	public void setBankNo(int bankNo) {
		BankNo = bankNo;
	}

	public User(int govtId, String username, String password, String emailId, int phoneNo, int bankNo) {
		//super();
		this.client_id = govtId;
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.BankNo = bankNo;
	}
	
	
}

package com.jspproject.bbs.dto;

import java.sql.Timestamp;

public class UserDto {


	String email;
	String pw;
	String name;
	String tel;
	String address;
	String github;
	Timestamp withdrawDate;
	Timestamp signupDate;
	int admin;
	int result;

	
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}


	public UserDto(String email) {
		super();
		this.email = email;
	}


	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public Timestamp getWithdrawDate() {
		return withdrawDate;
	}
	public void setWithdrawDate(Timestamp withdrawDate) {
		this.withdrawDate = withdrawDate;
	}
	public Timestamp getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(Timestamp signupDate) {
		this.signupDate = signupDate;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}

	
	
	
}//-------

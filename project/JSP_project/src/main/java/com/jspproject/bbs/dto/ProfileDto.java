package com.jspproject.bbs.dto;

public class ProfileDto {

	
	String userEmail;
	String userName;
	String phoneNumber;
	String userGit;
	String password;
	public ProfileDto() {
		// TODO Auto-generated constructor stub
	}
	public ProfileDto(String userEmail, String userName, String userGit) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userGit = userGit;
	}
	
	public ProfileDto(String userEmail, String userName, String phoneNumber, String userGit) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.userGit = userGit;
	}
	
	public ProfileDto(String userEmail, String userName, String phoneNumber, String userGit, String password) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.userGit = userGit;
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserGit() {
		return userGit;
	}
	public void setUserGit(String userGit) {
		this.userGit = userGit;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

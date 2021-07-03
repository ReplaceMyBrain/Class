package com.springlec.addressbook.dto;

public class ContentDto {

	private int aId;
	private String aName;
	private String aContent;
	private String aAddress;
	private String aEmail;
	private String aRelation;
	
	
	public ContentDto() {
	}


	public ContentDto(int aId, String aName, String aContent, String aAddress, String aEmail, String aRelation) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aContent = aContent;
		this.aAddress = aAddress;
		this.aEmail = aEmail;
		this.aRelation = aRelation;
	}


	public int getaId() {
		return aId;
	}


	public void setaId(int aId) {
		this.aId = aId;
	}


	public String getaName() {
		return aName;
	}


	public void setaName(String aName) {
		this.aName = aName;
	}


	public String getaContent() {
		return aContent;
	}


	public void setaContent(String aContent) {
		this.aContent = aContent;
	}


	public String getaAddress() {
		return aAddress;
	}


	public void setaAddress(String aAddress) {
		this.aAddress = aAddress;
	}


	public String getaEmail() {
		return aEmail;
	}


	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}


	public String getaRelation() {
		return aRelation;
	}


	public void setaRelation(String aRelation) {
		this.aRelation = aRelation;
	}
	
	
	
	
	
	
	
}

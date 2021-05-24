package com.jspproject.bbs.dto;

import java.sql.Date;

public class ContentNoticedto {
	int n_num;
	String name;
	String user_email;
	String n_title;
	String n_content;
	int n_hits;
	Date nw_regist;
	
	int nc_num;
	String nc_content;
	Date nc_regist;
	
	
	public ContentNoticedto(int n_num, String name, String user_email, String n_title, String n_content, int n_hits, Date nw_regist) {
	super();
	this.n_num = n_num;
	this.name = name;
	this.user_email = user_email;
	this.n_title = n_title;
	this.n_content = n_content;
	this.n_hits = n_hits;
	this.nw_regist = nw_regist;
}

	public ContentNoticedto(int nc_num, String nc_content) {
		super();
		this.nc_num = nc_num;
		this.nc_content = nc_content;
	}

	public ContentNoticedto(int nc_num, String name, String user_email, String nc_content, Date nc_regist) {
		super();
		this.nc_num = nc_num;
		this.name = name;
		this.user_email = user_email;
		this.nc_content = nc_content;
		this.nc_regist = nc_regist;
	}

	public ContentNoticedto() {
		// TODO Auto-generated constructor stub
	}
	

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getnc_num() {
		return nc_num;
	}

	public void setnc_num(int nc_num) {
		this.nc_num = nc_num;
	}

	public String getnc_content() {
		return nc_content;
	}

	public void setnc_content(String nc_content) {
		this.nc_content = nc_content;
	}

	public Date getnc_regist() {
		return nc_regist;
	}

	public void setnc_regist(Date nc_regist) {
		this.nc_regist = nc_regist;
	}

	public int getn_num() {
		return n_num;
	}

	public void setn_num(int n_num) {
		this.n_num = n_num;
	}

	public String getuser_email() {
		return user_email;
	}

	public void setuser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getn_title() {
		return n_title;
	}

	public void setn_title(String n_title) {
		this.n_title = n_title;
	}

	public String getn_content() {
		return n_content;
	}

	public void setn_content(String n_content) {
		this.n_content = n_content;
	}

	public int getn_hits() {
		return n_hits;
	}

	public void setn_hits(int n_hits) {
		this.n_hits = n_hits;
	}

	public Date getnw_regist() {
		return nw_regist;
	}

	public void setnw_regist(Date nw_regist) {
		this.nw_regist = nw_regist;
	}
	
	
}
package com.jspproject.bbs.dto;

import java.sql.Date;

public class ContentTipdto {
	int t_num;
	String name;
	String user_email;
	String t_title;
	String t_content;
	String t_category;
	int t_hits;
	Date tw_regist;
	
	int tc_num;
	String tc_content;
	Date tc_regist;
	
	
	// 굳이 이미지 가져올 필요가 없어
	String t_image;
	// int pLike = resultset.getInt("pLike");// Like수없나요?
	
	
	
	public ContentTipdto(int t_num, String name, String user_email, String t_title, String t_content, String t_image, String t_category,
		int t_hits, Date tw_regist) {
	super();
	this.t_num = t_num;
	this.name = name;
	this.user_email = user_email;
	this.t_title = t_title;
	this.t_content = t_content;
	this.t_image = t_image;
	this.t_category = t_category;
	this.t_hits = t_hits;
	this.tw_regist = tw_regist;
}

	public ContentTipdto(int tc_num, String tc_content) {
		super();
		this.tc_num = tc_num;
		this.tc_content = tc_content;
	}

	public ContentTipdto(int tc_num, String name, String user_email, String tc_content, Date tc_regist) {
		super();
		this.tc_num = tc_num;
		this.name = name;
		this.user_email = user_email;
		this.tc_content = tc_content;
		this.tc_regist = tc_regist;
	}

	public ContentTipdto() {
		// TODO Auto-generated constructor stub
	}
	

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int gettc_num() {
		return tc_num;
	}

	public void settc_num(int tc_num) {
		this.tc_num = tc_num;
	}

	public String gettc_content() {
		return tc_content;
	}

	public void settc_content(String tc_content) {
		this.tc_content = tc_content;
	}

	public Date gettc_regist() {
		return tc_regist;
	}

	public void settc_regist(Date tc_regist) {
		this.tc_regist = tc_regist;
	}

	public int gett_num() {
		return t_num;
	}

	public void sett_num(int t_num) {
		this.t_num = t_num;
	}

	public String getuser_email() {
		return user_email;
	}

	public void setuser_email(String user_email) {
		this.user_email = user_email;
	}

	public String gett_title() {
		return t_title;
	}

	public void sett_title(String t_title) {
		this.t_title = t_title;
	}

	public String gett_content() {
		return t_content;
	}

	public void sett_content(String t_content) {
		this.t_content = t_content;
	}

	public String gett_image() {
		return t_image;
	}

	public void sett_image(String iImg) {
		this.t_image = iImg;
	}

	public String gett_category() {
		return t_category;
	}

	public void sett_category(String t_category) {
		this.t_category = t_category;
	}

	public int gett_hits() {
		return t_hits;
	}

	public void sett_hits(int t_hits) {
		this.t_hits = t_hits;
	}

	public Date gettw_regist() {
		return tw_regist;
	}

	public void settw_regist(Date tw_regist) {
		this.tw_regist = tw_regist;
	}
	
	
}
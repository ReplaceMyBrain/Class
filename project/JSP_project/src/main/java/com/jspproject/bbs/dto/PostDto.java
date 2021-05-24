package com.jspproject.bbs.dto;

public class PostDto {
	int num;
	String title;
	String content;
	String image;
	String category;
	int views;
	
	public PostDto() {
		// TODO Auto-generated constructor stub
	}

	public PostDto(int num, String title, String content, String image, String category, int views) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.image = image;
		this.category = category;
		this.views = views;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	
}

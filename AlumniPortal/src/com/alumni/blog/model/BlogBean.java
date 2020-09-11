package com.alumni.blog.model;

public class BlogBean {

	private int blog_id;
	private String blog_title;
	private String blog_author;
	private String blog_content;
	
	private String blog_date ;
	private String photo;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getBlog_title() {
		return blog_title;
	}

	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}

	public String getBlog_author() {
		return blog_author;
	}

	public void setBlog_author(String blog_author) {
		this.blog_author = blog_author;
	}

	public String getBlog_content() {
		return blog_content;
	}

	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}

	public String getBlog_date() {
		return blog_date;
	}

	public void setBlog_date(String blog_date) {
		this.blog_date = blog_date;
	}
	
	
}

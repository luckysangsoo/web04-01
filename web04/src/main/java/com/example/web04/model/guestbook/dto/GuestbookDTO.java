package com.example.web04.model.guestbook.dto;

import java.sql.Date;

public class GuestbookDTO {

	private int idx;
	private String name;
	private String passwd;
	private String content;
	private Date post_date; //java.sql.Date
	private String email;
		
	//getter, setter
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	
	//toString
	@Override
	public String toString() {
		return "GuestbookDTO [idx=" + idx + ", name=" + name + ", passwd=" + passwd + ", content=" + content
				+ ", post_date=" + post_date + ", email=" + email + "]";
	}
	
	
	
}

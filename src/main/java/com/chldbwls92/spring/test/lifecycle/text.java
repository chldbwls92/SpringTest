package com.chldbwls92.spring.test.lifecycle;

public class text {
	
	private String title;
	private String user;
	private String content;
	
	public text(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "title : " + title + "\n user" + user + "\n content : " + content;
	}

	
	// 개터들
	public String getTitle() {
		return title;
	}

	public String getUser() {
		return user;
	}

	public String getContent() {
		return content;
	}
	
	
	
}

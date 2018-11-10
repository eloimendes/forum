package br.com.alura.forum.controller.request;

import java.util.UUID;

public class CreateQuestionRequest {
	
	private UUID course;
	private String title;
	private UUID user;
	
	public UUID getCourse() {
		return course;
	}
	public void setCourse(UUID course) {
		this.course = course;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public UUID getUser() {
		return user;
	}
	public void setUser(UUID user) {
		this.user = user;
	}
	
	

}

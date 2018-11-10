package br.com.alura.forum.controller.response;

import java.util.UUID;

public class CreateQuestionResponse  {
	
	private UUID answer;
	private String title;
	private UUID user;
	
	public UUID getAnswer() {
		return answer;
	}
	public void setAnswer(UUID answer) {
		this.answer = answer;
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

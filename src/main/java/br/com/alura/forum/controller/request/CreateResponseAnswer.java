package br.com.alura.forum.controller.request;

import java.util.UUID;

public class CreateResponseAnswer {
	
	private String answer;
	private UUID user;
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public UUID getUser() {
		return user;
	}
	public void setUser(UUID user) {
		this.user = user;
	}

}

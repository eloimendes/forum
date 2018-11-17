package br.com.alura.forum.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import br.com.alura.forum.entities.Answer;

public class QuestionView {

	private UUID id;
	
	private String title;
	
	private UUID user;
	
	private String userName;
	
	private Instant instant;
	
	private UUID course;
	private String courseName;
	
	private Collection<AnswerView> answers = new ArrayList<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public UUID getCourse() {
		return course;
	}

	public void setCourse(UUID course) {
		this.course = course;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Collection<AnswerView> getAnswers() {
		return answers;
	}

	public void setAnswers(Collection<AnswerView> answers) {
		this.answers = answers;
	}
	
	
}

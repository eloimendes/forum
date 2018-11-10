package br.com.alura.forum.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.assertj.core.util.Lists;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Question {
		
	@Id
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@GeneratedValue(generator="uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;
	
	private String title;
	
	@Column(columnDefinition = "BINARY(16)")
	private UUID user;
	
	private Instant instant;
	
	@Column(columnDefinition = "BINARY(16)")
	private UUID course;
	
	@OneToMany(mappedBy="question", cascade=CascadeType.ALL) 
	private Collection<Answer> answers = new ArrayList<>();
	

	public UUID getId() {
		return id;
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
	
	public void addAnswer(Answer answer) {
		answer.setQuestion(this);
		answers.add(answer);
	}
	
	public Collection<Answer> getAnswers(){
		return answers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

package br.com.alura.forum.entities;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Answer {

	@Id
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@GeneratedValue(generator="uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;

	private String answer;

	@Column(columnDefinition = "BINARY(16)")
	private UUID user;

	private Instant instant;

	private boolean solved;
	
	@ManyToOne
	private Question question;

	
	
	public UUID getId() {
		return id;
	}

	public String getAnswer() {
		return answer;
	}

	public UUID getUser() {
		return user;	
	}

	public Instant getInstant() {
		return instant;
	}

	public boolean isSolved() {
		return solved;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setUser(UUID user) {
		this.user = user;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	
	

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
		Answer other = (Answer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

package br.com.alura.forum.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.forum.controller.request.CreateResponseAnswer;
import br.com.alura.forum.entities.Answer;
import br.com.alura.forum.entities.Question;
import br.com.alura.forum.exception.QuestionNotFoundException;
import br.com.alura.forum.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public Optional<Question> findById(UUID id){
		return questionRepository.findById(id);
	}
	
	public Iterable<Question> findAll(){
		return questionRepository.findAll();
	}
	
	public Question save(Question question){
		return questionRepository.save(question);
	}

	@Transactional
	public Question answer(UUID id, CreateResponseAnswer request){
		Question question = this.questionRepository.findById(id).orElseThrow(() -> new QuestionNotFoundException());
	
		Answer answer = new Answer();
		answer.setAnswer(request.getAnswer());
		answer.setUser(request.getUser());
		answer.setInstant(Instant.now());
		
		question.addAnswer(answer);

		return question;
	}
}

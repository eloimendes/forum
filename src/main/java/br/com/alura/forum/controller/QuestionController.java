package br.com.alura.forum.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.request.CreateQuestionRequest;
import br.com.alura.forum.controller.request.CreateResponseAnswer;
import br.com.alura.forum.entities.Answer;
import br.com.alura.forum.entities.Question;
import br.com.alura.forum.repositories.AnswerRepository;
import br.com.alura.forum.repositories.QuestionRepository;

@RestController
@RequestMapping(value="/api/questions")
public class QuestionController {

	private final QuestionRepository questionRepository;
	private final AnswerRepository answerRepository;
	
	@Autowired
	public QuestionController(QuestionRepository questionRepository, AnswerRepository answerRepository) {
		this.questionRepository = questionRepository;
		this.answerRepository = answerRepository;
	}
	
	@PostMapping
	public ResponseEntity<QuestionView> create(@RequestBody CreateQuestionRequest request){
		
		Question question = new Question();
		question.setCourse(request.getCourse());
		question.setInstant(Instant.now());
		question.setTitle(request.getTitle());
		question.setUser(request.getUser());
		
		Question saved = this.questionRepository.save(question);
		return new ResponseEntity(buildQuestion(saved), HttpStatus.CREATED);
		
	}
	
	@PostMapping("{id}") 
	@Transactional
	public ResponseEntity<?> reponse(@PathVariable UUID id, @RequestBody CreateResponseAnswer request) {
		
		System.out.println(id);
		Optional<Question> optional = this.questionRepository.findById(id);
		
		optional.ifPresent(question -> {
			
			Answer answer = new Answer();
			answer.setAnswer(request.getAnswer());
			answer.setUser(request.getUser());
			answer.setInstant(Instant.now());
			
			question.addAnswer(answer);
			
		});	
		
		return optional.map(q -> ResponseEntity.ok().body(buildQuestion(q))).orElseGet(ResponseEntity.notFound()::build);
	}
	
	@GetMapping("{id}") 
	public ResponseEntity<?> findById(@PathVariable UUID id) {
		
		Optional<Question> optional = this.questionRepository.findById(id);
		
		return optional.map(q -> ResponseEntity.ok().body(buildQuestion(q))).orElseGet(ResponseEntity.notFound()::build);
	}
	
	private QuestionView buildQuestion(Question question) {
		QuestionView view = new QuestionView();
		view.setId(question.getId());
		view.setCourse(question.getCourse());
		view.setInstant(question.getInstant());
		view.setTitle(question.getTitle());
		view.setAnswers(buildAnswers(question.getAnswers()));
		return view;
	}

	private Collection<AnswerView> buildAnswers(Collection<Answer> answers) {
		Collection<AnswerView> v = new ArrayList<>();
		for(Answer answer : answers){
			AnswerView answerView = new AnswerView();
			answerView.setAnswer(answer.getAnswer());
			answerView.setId(answer.getId());
			answerView.setInstant(answer.getInstant());
			answerView.setSolved(answer.isSolved());
			answerView.setUser(answer.getUser());
			v.add(answerView);
		}
		return v;
	}

	@GetMapping
	public ResponseEntity<Collection<Question>> list() {
		
		Iterable<Question> all = this.questionRepository.findAll();
		
		Collection<QuestionView> questions = buildQuestions(all);
		
		return new ResponseEntity(questions, HttpStatus.OK);
	}

	private Collection<QuestionView> buildQuestions(Iterable<Question> all) {
		Collection<QuestionView> questions = new ArrayList<>();
		for(Question q : all){
			QuestionView v = buildQuestion(q);
			questions.add(v );
		}
		return questions;
	}
	
}

package br.com.alura.forum.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.forum.entities.Question;

public interface QuestionRepository extends CrudRepository<Question, UUID> {

	List<Question> findByUser(UUID id);
}

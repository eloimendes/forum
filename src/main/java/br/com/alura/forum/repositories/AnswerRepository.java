package br.com.alura.forum.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.entities.Question;

public interface AnswerRepository extends JpaRepository<Question, UUID> {

}

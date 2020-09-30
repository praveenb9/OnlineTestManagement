package com.capg.otms.question.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.otms.question.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

	public Question findByQuestionId(long questionId);

}

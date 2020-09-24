package com.capg.otms.question.service;

import java.util.List;

import com.capg.otms.question.model.Question;

public interface IQuestionService {

	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public boolean deleteQuestion(long questionId);
	public List<Question> getAllQuestions();
	public Question getQuestion(long questionId);

}

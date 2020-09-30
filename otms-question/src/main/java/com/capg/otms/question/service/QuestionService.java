/********************************************************************************
 -Author                : Praveen Bandi
 -Created/Modified Date : 23/09/2020
 -Description           : Implementation Class of Question serivce Interface for 
 								Performing Services Related To Questions
*********************************************************************************/
package com.capg.otms.question.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capg.otms.question.exception.QuestionAlreadyExistException;
import com.capg.otms.question.exception.QuestionDoesNotExistException;
import com.capg.otms.question.exception.QuestionIdNotNullException;
import com.capg.otms.question.model.Question;
import com.capg.otms.question.repo.QuestionRepo;

@Service
public class QuestionService implements IQuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	/*************************************************************************
	 -MethodName          : addQuestion
	 -Input Parameters      : Question question
	 -Return Type           : Question
	 -Throws				: QuestionAlreadyExistException,QuestionIdNotNullException
	 -Author				: Praveen Bandi
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Question addQuestion(Question question) {
       
		if( question.getQuestionId()==null)
		{
			throw new QuestionIdNotNullException("Invalid Question Id : Id should not be Null");
		}
		if(question.getQuestionId()<0)
		{
			throw new QuestionIdNotNullException("Invalid Question Id : Id should not be Negative");
		}
		if(questionRepo.existsById(question.getQuestionId()))
		{
			throw new QuestionAlreadyExistException("Question Already Exist");
		}
	return questionRepo.save(question);
	}
	

	/*************************************************************************
	 -MethodName          : updateQuestion
	 -Input Parameters      : Question question
	 -Return Type           : Question
	 -Throws				: QuestionDoesNotExistException
	 -Author				: Praveen Bandi
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Question updateQuestion(Question question) {
		if (!questionRepo.existsById(question.getQuestionId())) {

			throw new QuestionDoesNotExistException("Question Does Not Exist ");
		}
		Question updateQuestion=questionRepo.findByQuestionId(question.getQuestionId());
		updateQuestion.setChoosenAnswer(question.getChoosenAnswer());
		updateQuestion.setMarksScored(question.getMarksScored());
		updateQuestion.setQuestionAnswer(question.getQuestionAnswer());
		updateQuestion.setQuestionMarks(question.getQuestionMarks());
		updateQuestion.setQuestionOptions(question.getQuestionOptions());
		updateQuestion.setQuestionTitle(question.getQuestionTitle());
		
		
		return questionRepo.save(updateQuestion);
		
	}

	/*************************************************************************
	 -MethodName          : deleteQuestion
	 -Input Parameters      : long questionId
	 -Return Type           : boolean
	 -Throws				: QuestionDoesNotExistException
	 -Author				: Praveen Bandi
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public boolean deleteQuestion(long questionId) {
		if(!questionRepo.existsById(questionId))
		{
			throw new QuestionDoesNotExistException("Invalid Question Id / Question Does Not Exist");
		}
		else
		{
			questionRepo.deleteById(questionId);
			return true;
		}
		
	}

	@Override
	public List<Question> getAllQuestions() {
		if(questionRepo.findAll().size()==0)
		{
			throw new QuestionDoesNotExistException("Question List is Empty");
		}
		return questionRepo.findAll();
	}

	/*************************************************************************
	 -MethodName          : getQuestion
	 -Input Parameters      : long questionId
	 -Return Type           : Question
	 -Throws				: QuestionDoesNotExistException
	 -Author				: Praveen Bandi
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Question getQuestion(long questionId) {

		if(!questionRepo.existsById(questionId)) {
			throw new QuestionDoesNotExistException("Invalid Question Id / Question Does Not Exist"); 
		}
		return questionRepo.findByQuestionId(questionId);
	}

	
	


}

package com.capg.otms.user.service;

import java.util.List;

import com.capg.otms.user.model.Question;

import com.capg.otms.user.model.Tests;
import com.capg.otms.user.model.User;


public interface IUserService {

	User addUser(User user);
	User deleteUser(long userId);
	User updateUser(User user);
	User getUser(long userId);
	List<User> getAllUsers();
	User getByUserName(String userName);
	boolean validateUserName(String userName);
	boolean validateUserPassword(String userPassword);
	boolean assingTest(long userId,long testId);
	
	Tests addTest(Tests test);
	Tests getTest(long testId);
	List<Tests> fetchAllTests();
	Tests updateTest(Tests newTestData);
	Tests deleteTest(long testId);
	List<Question> getTestQuestion(long testId);
	double calculateTotalMarks(long testId);
	Tests assignQuestion(long testId,long questionId);
	
	Question addQuestion(Question question);
	Question updateQuestion(Question question);
	Question deleteQuestion(long questionId);
	Question getQuestion(long questionId);
	List<Question> getAllQuestions();
	
}

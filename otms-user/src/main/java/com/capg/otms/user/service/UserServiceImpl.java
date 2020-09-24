package com.capg.otms.user.service;

import java.util.Arrays;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import com.capg.otms.user.exception.InvalidInputException;
import com.capg.otms.user.exception.UserAlreadyExistsException;
import com.capg.otms.user.exception.UserNotFoundException;
import com.capg.otms.user.model.Question;

import com.capg.otms.user.model.Tests;
import com.capg.otms.user.model.User;
import com.capg.otms.user.repo.IUserRepo;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	RestTemplate rt;
	
	@Autowired
	IUserRepo userRepo;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		if(userRepo.existsById(user.getUserId())) {
			
			throw new UserAlreadyExistsException("the user already exit please give the new details");
		}
		else {
			String s= Long.toString(user.getUserId());
			if(!(user.getUserId()>0 && s.length()>=3)) {
				throw new InvalidInputException("please enter a three or more digit id and it should not be negative");
			}
		}
		if(!(validateUserName(user.getUserName())==true && validateUserPassword(user.getUserPassword())==true)) {
			
			throw new InvalidInputException("the user name should be starting with capital letter and it can be alphanumaric"
					+ "please enter the password as required");
		}
		
		return userRepo.save(user);
	}

	@Override
	public User deleteUser(long userId) {
		// TODO Auto-generated method stub
		User deleteUser = userRepo.getOne(userId);
		userRepo.deleteById(userId);
		return deleteUser;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		if(!userRepo.existsById(user.getUserId())) {
			
			throw new UserNotFoundException("the user does not exist, please check the details");
		}
		else {
		
			User updateUser = userRepo.getOne(user.getUserId());
			updateUser.setUserName(user.getUserName());
		    updateUser.setUserPassword(user.getUserPassword());
		    updateUser.setUserTest(user.getUserTest());
		    updateUser.setAdminOrNot(user.isAdminOrNot());
		    return updateUser;
		 }
	}

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
			if(!userRepo.existsById(userId)) {
				
			throw new UserNotFoundException("the with following "+userId+" does not exists");
		}
		return userRepo.getOne(userId);
	}
	@Override
	public boolean validateUserName(String userName) {
		// TODO Auto-generated method stub
		String regex="[(?=.*[A-Za-z])(?=.*[0-9].{2,4})]{5,}";
		if(userName.matches(regex)) {
			return true;
		}
		else
			throw new InvalidInputException("the user name should be starting with capital letter and it can be alphanumaric");
		
	}

	@Override
	public boolean validateUserPassword(String userPassword) {
		// TODO Auto-generated method stub
		String regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		if(userPassword.matches(regex)) {
			return true;
		}
		else 
			throw new InvalidInputException("Password should contain:- [uppercase ,lowercase ,numeric ,any of the characters ,should contain atleast 8 characters]");
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getByUserName(String userName) {
		// TODO Auto-generated method stub
	
		return userRepo.getByUserName(userName);
		
	}
	
	@Override
	public boolean assingTest(long userId, long testId) {
		// TODO Auto-generated method stub
		boolean status=true;
		User  user=userRepo.getOne(userId);
		Tests test=rt.getForObject("http://localhost:8020/test/id/"+testId, Tests.class);
		if(user!=null && !user.isAdminOrNot() && test!=null) {
			user.setUserTest(testId);
			userRepo.save(user);
			return status;
		}
		else {
		
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		Question q=rt.postForObject("http://localhost:8787/question/add", question, Question.class);
		return q;
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		question.getQuestionId();
		Question q1=rt.getForObject("http://localhost:8787/question/get/id/"+question.getQuestionId(), Question.class);
		rt.put("http://localhost:8787/question/update", question,question);
		return q1;
	}

	@Override
	public Question deleteQuestion(long questionId) {
		// TODO Auto-generated method stub
		Question q=rt.getForObject("http://localhost:8787/question/get/id/"+questionId, Question.class);
		rt.delete("http://localhost:8787/question/delete/id/"+questionId,questionId);
		return q;
	}

	@Override
	public Question getQuestion(long questionId) {
		// TODO Auto-generated method stub
		Question q=rt.getForObject("http://localhost:8787/question/get/id/"+questionId, Question.class);
		
		return q;
	}

	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		Question[] questionList=rt.getForObject("http://localhost:8787/question/getAll", Question[].class);
		return Arrays.asList(questionList);
	}

	@Override
	public Tests addTest(Tests test) {
		// TODO Auto-generated method stub
		Tests t=rt.postForObject("http://localhost:8020/test/add", test, Tests.class);
		return t;
	}

	@Override
	public Tests getTest(long testId) {
		// TODO Auto-generated method stub
		Tests t= rt.getForObject("http://localhost:8020/test/id/"+testId, Tests.class);
		return t;
	}

	@Override
	public List<Tests> fetchAllTests() {
		// TODO Auto-generated method stub
		Tests[] tList=rt.getForObject("http://localhost:8020/test/all", Tests[].class);
		return  Arrays.asList(tList);
		
	}

	@Override
	public Tests updateTest(Tests newTestData) {
		// TODO Auto-generated method stub
		Tests t=rt.getForObject("http://localhost:8020/test/id/"+newTestData.getTestId(), Tests.class);
		rt.put("http://localhost:8020/test/update", Tests.class);
		return t;
	}

	@Override
	public Tests deleteTest(long testId) {
		// TODO Auto-generated method stub
		Tests t=rt.getForObject("http://localhost:8020/test/id/"+testId, Tests.class);
		 rt.delete("http:/localhost:8020/test/delete/id/"+testId,testId);
		 return t;
	}

	@Override
	public List<Question> getTestQuestion(long testId) {
		// TODO Auto-generated method stub
		Question[] q= rt.getForObject("http://localhost:8020/test/questions/"+testId, Question[].class);
		return Arrays.asList(q);
	}

	@Override
	public double calculateTotalMarks(long testId) {
		// TODO Auto-generated method stub
		Tests testMarks=rt.getForObject("http://localhost:8020/test/id/"+testId, Tests.class);
		double result=0;
		result=rt.getForObject("http://localhost:8020/test/calculate/"+testId,Double.class);
		testMarks.setTestMarksScored(result);
		
		return testMarks.getTestMarksScored();
	}

	@Override
	public Tests assignQuestion(long testId, long questionId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	

}

/********************************************************************************
 -Author                : Tutha Sai Charan
 -Created/Modified Date : 23/09/2020
 -Description           : Implementation Class of User serivce Interface for 
 						  Performing Services Related To User
*********************************************************************************/


package com.capg.otms.user.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.capg.otms.user.exception.InvalidInputException;
import com.capg.otms.user.exception.InvalidPasswordException;
import com.capg.otms.user.exception.UserAlreadyExistsException;
import com.capg.otms.user.exception.UserNotFoundException;
import com.capg.otms.user.model.Question;

import com.capg.otms.user.model.Tests;
import com.capg.otms.user.model.User;
import com.capg.otms.user.model.UserCredentials;
import com.capg.otms.user.repo.IUserRepo;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	RestTemplate rt;
	
	@Autowired
	IUserRepo userRepo;
	
	/*************************************************************************
	 -MethodName            : addUser
	 -Input Parameters      : User user
	 -Return Type           : User
	 -Throws				: UserAlreadyExistsException,InvalidInputException
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
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

	/*************************************************************************
	 -MethodName            : deleteUser
	 -Input Parameters      : long userId
	 -Return Type           : User
	 -Throws				: UserNotFoundException
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public User deleteUser(long userId) {
		// TODO Auto-generated method stub
		
		User deleteUser = userRepo.getOne(userId);
		if(deleteUser!=null) {
		userRepo.deleteById(userId);}
		else 
			throw new UserNotFoundException("no user found "+userId+" with this id");
		return deleteUser;
	}

	/*************************************************************************
	 -MethodName            : updateUser
	 -Input Parameters      : User user
	 -Return Type           : User
	 -Throws				: UserNotFoundException
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
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

	/*************************************************************************
	 -MethodName            : getUser
	 -Input Parameters      : long userId
	 -Return Type           : User
	 -Throws				: UserNotFoundException
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
			if(!userRepo.existsById(userId)) {
				
			throw new UserNotFoundException("the with following "+userId+" does not exists");
		}
		return userRepo.getOne(userId);
	}
	
	/*************************************************************************
	 -MethodName            : validateUserName
	 -Input Parameters      : String userName
	 -Return Type           : boolean
	 -Throws				: InvalidInputException
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
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

	/*************************************************************************
	 -MethodName            : validateUserPassword
	 -Input Parameters      : String userPassword
	 -Return Type           : boolean
	 -Throws				: InvalidInputException
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
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
	
	/*************************************************************************
	 -MethodName            : getAllUsers
	 -Input Parameters      : -
	 -Return Type           : List of users
	 -Throws				: -
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	/*************************************************************************
	 -MethodName            : getByUserName
	 -Input Parameters      : String userName
	 -Return Type           : User
	 -Throws				: -
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public User getByUserName(String userName) {
		// TODO Auto-generated method stub
	
		return userRepo.getByUserName(userName);
		
	}
	
	/*************************************************************************
	 -MethodName            : assingTest
	 -Input Parameters      : long userId,long testId
	 -Return Type           : boolean
	 -Throws				: ResponseStatusException
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
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

	/*************************************************************************
	 -MethodName            : addQuestion
	 -Input Parameters      : Question question
	 -Return Type           : Question
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		Question q=rt.postForObject("http://localhost:8787/question/add", question, Question.class);
		return q;
	}

	/*************************************************************************
	 -MethodName            : updateQuestion
	 -Input Parameters      : Question question
	 -Return Type           : Question
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		question.getQuestionId();
		Question q1=rt.getForObject("http://localhost:8787/question/get/id/"+question.getQuestionId(), Question.class);
		rt.put("http://localhost:8787/question/update", question,question);
		return q1;
	}

	/*************************************************************************
	 -MethodName            : deleteQuestion
	 -Input Parameters      : long questionId
	 -Return Type           : Question
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Question deleteQuestion(long questionId) {
		// TODO Auto-generated method stub
		Question q=rt.getForObject("http://localhost:8787/question/get/id/"+questionId, Question.class);
		rt.delete("http://localhost:8787/question/delete/id/"+questionId,questionId);
		return q;
	}

	/*************************************************************************
	 -MethodName            : getQuestion
	 -Input Parameters      : long questionId
	 -Return Type           : Question
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Question getQuestion(long questionId) {
		// TODO Auto-generated method stub
		Question q=rt.getForObject("http://localhost:8787/question/get/id/"+questionId, Question.class);
		
		return q;
	}

	/*************************************************************************
	 -MethodName            : getAllQuestions
	 -Input Parameters      : -
	 -Return Type           : list of questions
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		Question[] questionList=rt.getForObject("http://localhost:8787/question/getAll", Question[].class);
		return Arrays.asList(questionList);
	}

	/*************************************************************************
	 -MethodName            : addTest
	 -Input Parameters      : Tests test
	 -Return Type           : Tests
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Tests addTest(Tests test) {
		// TODO Auto-generated method stub
		Tests t=rt.postForObject("http://localhost:8020/test/add", test, Tests.class);
		return t;
	}

	/*************************************************************************
	 -MethodName            : getTest
	 -Input Parameters      : long testId
	 -Return Type           : Tests
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Tests getTest(long testId) {
		// TODO Auto-generated method stub
		Tests t= rt.getForObject("http://localhost:8020/test/id/"+testId, Tests.class);
		return t;
	}

	/*************************************************************************
	 -MethodName            : fetchAllTests
	 -Input Parameters      : -
	 -Return Type           : list of tests
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public List<Tests> fetchAllTests() {
		// TODO Auto-generated method stub
		Tests[] tList=rt.getForObject("http://localhost:8020/test/all", Tests[].class);
		return  Arrays.asList(tList);
		
	}

	/*************************************************************************
	 -MethodName            : updateTest
	 -Input Parameters      : Tests newTestData
	 -Return Type           : Tests
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Tests updateTest(Tests newTestData) {
		// TODO Auto-generated method stub
		System.out.println("controller "+newTestData);
		//Tests t=rt.getForObject("http://localhost:8020/test/id/"+newTestData.getTestId(), Tests.class);
		rt.put("http://localhost:8020/test/update", newTestData);
		return newTestData;
	}

	/*************************************************************************
	 -MethodName            : deleteTest
	 -Input Parameters      : long testId
	 -Return Type           : Tests
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public Tests deleteTest(long testId) {
		// TODO Auto-generated method stub
		Tests t=rt.getForObject("http://localhost:8020/test/id/"+testId, Tests.class);
		 rt.delete("http://localhost:8020/test/delete/id/"+testId,testId);
		 return t;
	}

	/*************************************************************************
	 -MethodName            : getTestQuestion
	 -Input Parameters      : long testId
	 -Return Type           : list of question
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public List<Question> getTestQuestion(long testId) {
		// TODO Auto-generated method stub
		Question[] q= rt.getForObject("http://localhost:8020/test/questions/"+testId, Question[].class);
		System.out.println(Arrays.asList(q));
		return Arrays.asList(q);
	}

	/*************************************************************************
	 -MethodName            : calculateTotalMarks
	 -Input Parameters      : long testId
	 -Return Type           : double
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/
	@Override
	public double calculateTotalMarks(long testId) {
		// TODO Auto-generated method stub
		Tests testMarks=rt.getForObject("http://localhost:8020/test/id/"+testId, Tests.class);
		double result=0;
		result=rt.getForObject("http://localhost:8020/test/calculate/"+testId,Double.class);
		testMarks.setTestMarksScored(result);
		
		return testMarks.getTestMarksScored();
	}
	/*************************************************************************
	 -MethodName            : assingQuestion
	 -Input Parameters      : long questionId,long testId
	 -Return Type           : Tests
	 -Author				: Tutha Sai Charan
	 -Modified Date			: 23/09/2020
	***************************************************************************/

	@Override
	public Tests assignQuestion(long testId, long questionId) {
		
		Tests test=rt.getForObject("http://localhost:8020/test/id/"+testId,Tests.class);
		test.getTestQuestions().add(questionId);
//		Set<Long> questions=test.getTestQuestions();
//		questions.add(questionId);
		return test;
	}

	@Override
	public User validateUser(UserCredentials credentials) {
		
		if(!userRepo.existsById(credentials.getUserId()))
		{
			throw new UserNotFoundException("User Not Found");
		}
		User user=userRepo.getOne(credentials.getUserId());
		if(user.getUserPassword().equals(credentials.getPassword()))
		{
			return user;
		}
		else
		{
			throw new InvalidPasswordException("Invalid Password");
		}
	}

	

}

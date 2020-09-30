package com.capg.otms.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.otms.exception.TestAlreadyExists;
import com.capg.otms.exception.TestIdNotNullException;
import com.capg.otms.exception.TestNotFoundException;
import com.capg.otms.model.Question;
import com.capg.otms.model.Tests;
import com.capg.otms.repository.ITestJpaRepo;



@Service
public class TestService implements ITestServiceImp{


	
	@Autowired(required = true)
	ITestJpaRepo testRepo;
	
	@Autowired
	RestTemplate rt;
	
	/*************************************
	 -Function Name   : ADD TEST
	 -Input parameter : Test test
	 -Author          : Andey sathvika
	 -Creation Date   : 21-09-2020 
	 ***************************************/
     @Override
	 @Transactional
	  public Tests addtest (Tests test) {
		  System.out.println(test);
		  if(testRepo.existsById(test.getTestId())) {
			 throw new TestAlreadyExists("Test Already Exits");
		  }
		 return testRepo.save(test);
	  }	
	 
		
     /*************************************
	 -Function Name   : DELETE TEST
	 -Input parameter : long testId
	 -Author          : Andey sathvika
	 -Creation Date   : 21-09-2020 
	 ***************************************/
		@Override
		@Transactional
		public Tests deleteTest(long testId) {
		  if(!testRepo.existsById(testId)) {
			  throw new TestNotFoundException("Invalid test id:Test does not exist");
		  }
		  else {
			Tests deletedTest=testRepo.getOne(testId);
			testRepo.deleteById(testId);
			return deletedTest;
		}
	  }
	  
	  
		/*************************************
		 -Function Name   : GET TEST
		 -Input parameter : long testId
		 -Author          : Andey sathvika
		 -Creation Date   : 21-09-2020 
		 ***************************************/
		
		@Override
		public Tests getTest(long testId) {
			
			if(!testRepo.existsById(testId)) {
				throw new TestNotFoundException("Test with id : ["+testId+"] Not Found"); 
			}
			return testRepo.getOne(testId);
		}
	
		/*************************************
		 -Function Name   : GET ALL TESTS
		 -Input parameter : -
		 -Author          : Andey sathvika
		 -Creation Date   : 21-09-2020 
		 ***************************************/
	
	@Override
	public List<Tests> fetchAllTests(){	
		return testRepo.findAll();
	}
	
	
	/*************************************
	 -Function Name   : UPDATE TEST
	 -Input parameter : tests newTestData
	 -Author          : Andey sathvika
	 -Creation Date   : 21-09-2020 
	 ***************************************/
	
	@Transactional
	public Tests updateTest(Tests newTestData) {
		Tests test=testRepo.getOne(newTestData.getTestId());		
		test.setTestTitle(newTestData.getTestTitle());
		test.setTestDuration(newTestData.getTestDuration());
		test.setTestQuestions(newTestData.getTestQuestions());
		test.setTestTotalMarks(newTestData.getTestTotalMarks());
		test.setTestMarksScored(newTestData.getTestMarksScored());
		test.setCurrentQuestion(newTestData.getCurrentQuestion());
		test.setStartTime(newTestData.getStartTime());
		test.setEndTime(newTestData.getEndTime());
		testRepo.save(test);
		return test;
}
	
	
	/*************************************
	 -Function Name   : GET TEST QUESTION
	 -Input parameter : long testId
	 -Author          : Andey sathvika
	 -Creation Date   : 21-09-2020 
	 ***************************************/
	
	@Override
	public List<Question> getTestQuestions(long testId) {
		if(!testRepo.existsById(testId)) {
			throw new TestNotFoundException("Invalid testid: Test not found");
		}
		else {
		Tests test = testRepo.getOne(testId);
		List<Long> qIds = new ArrayList(test.getTestQuestions());
		List<Question> questions = new ArrayList<>();
		for(int i=0; i<qIds.size();i++)
		{
			Question q = rt.getForObject("http://localhost:8787/question/get/id/"+qIds.get(i), Question.class);

			questions.add(q);
		}
		return questions;
		}
	}
	
	
	/*************************************
	 -Function Name   : CALCULATE TOTAL MARKS
	 -Input parameter : long testId
	 -Author          : Andey sathvika
	 -Creation Date   : 21-09-2020 
	 ***************************************/
	
	@Override
	public double calculateTotalMarks(long testId) {
		if(!testRepo.existsById(testId)) {
			throw new TestNotFoundException("Invalid testid: Test not found");
		}
		else {
		double score=0;
		Tests test = testRepo.getOne(testId);
		List<Long> qIds = new ArrayList(test.getTestQuestions());
		for(int i=0; i<qIds.size();i++) {
			Question q = rt.getForObject("http://localhost:8787/question/get/id/"+qIds.get(i), Question.class);
			score = score + q.getMarksScored();
		}
		return score;
		}
	}
}



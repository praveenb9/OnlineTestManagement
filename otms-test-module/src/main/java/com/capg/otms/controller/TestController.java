package com.capg.otms.controller;



import java.time.LocalDateTime;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capg.otms.model.Question;
import com.capg.otms.model.Tests;
import com.capg.otms.service.TestService;



@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	 TestService service;
	
	
	/*...........ADD TEST.............*/
	@PostMapping("/add")
	public ResponseEntity<Tests> addTest(@RequestBody Tests test){
		service.addtest(test);
		return new ResponseEntity<Tests>(test,HttpStatus.CREATED);
	}
	
	
	
	/*.........DELETE TEST..........*/
	@DeleteMapping("delete/id/{testId}")
	public ResponseEntity<Tests> deleteTest(@PathVariable long testId){
	Tests deleted = service.deleteTest(testId);
	if(deleted.getTestId()==testId)
		return new ResponseEntity<Tests>(HttpStatus.OK);
	  return new ResponseEntity<Tests>(HttpStatus.NOT_FOUND);
	
	}

	
	
	/*...........SEARCH TEST............*/
	@GetMapping("/id/{testId}")
	public ResponseEntity<Tests> getTest(@PathVariable long testId){
	Tests test=service.getTest(testId);	
	return new ResponseEntity<Tests>(test,HttpStatus.OK);
	}
	
	
	
	/*...........GET TESTS.............*/
	@GetMapping("/all")
	public ResponseEntity<List<Tests>> getAllTests(){
	List<Tests> allTests=service.fetchAllTests();	
	return new ResponseEntity<List<Tests>>(allTests,HttpStatus.OK);
	}
	
	
		
	
	/*...........UPDATE TEST...........*/
	@PutMapping("/update")
	public ResponseEntity<Tests> updateTest(@RequestBody Tests test){
		Tests newTest=service.updateTest(test);
		return new ResponseEntity<Tests>(test,HttpStatus.OK);
	}
	
	
	
	/*.............GET QUESTIONS.............*/
	@GetMapping("/questions/{testId}")
	public List<Question> getTestQuestions(@PathVariable long testId){
		return service.getTestQuestions(testId);
	}
	
	
	/*............CALCULATE TOTAL SCORE...........*/
	@GetMapping("/calculate/{testId}")
	public ResponseEntity<Double> calculateTotalMarks(@PathVariable long testId){
		double result=service.calculateTotalMarks(testId);
		return new ResponseEntity<Double>(result,HttpStatus.OK);
}
		
	
}





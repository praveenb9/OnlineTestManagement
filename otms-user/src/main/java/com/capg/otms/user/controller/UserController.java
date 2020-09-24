/********************************************************************************
 -Author                : Tutha Sai Charan
 -Created/Modified Date : 23/09/2020
 -Description           : Controller for Performing CRUD Operations On User and 
                          integration part
*********************************************************************************/


package com.capg.otms.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.otms.user.model.Question;

import com.capg.otms.user.model.Tests;
import com.capg.otms.user.model.User;
import com.capg.otms.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
	}
	@DeleteMapping("/delete/id/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable long userId) {
		return new ResponseEntity<User>(userService.deleteUser(userId), HttpStatus.OK);
	}
	@GetMapping("/get/id/{userId}")
	public ResponseEntity<User> getUser(@PathVariable long userId) {
		return new ResponseEntity<User>(userService.getUser(userId), HttpStatus.FOUND);
	}
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	@GetMapping("/name/{userName}")
	public ResponseEntity<User> getUserByName(@PathVariable String userName) {
		return new ResponseEntity<User>(userService.getByUserName(userName), HttpStatus.FOUND);
	}
	@PutMapping("/userId/{userId}/testId/{testId}")
	public ResponseEntity<Boolean> assignTest(@PathVariable long userId,@PathVariable long testId){
		boolean result= userService.assingTest(userId, testId);
		return new ResponseEntity<Boolean>(result,HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/add/question")//done
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return new ResponseEntity<Question>(userService.addQuestion(question),HttpStatus.OK);
	}
	@PutMapping("/question/update")//done 
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return new ResponseEntity<Question>(userService.updateQuestion(question),HttpStatus.OK);
	}
	@DeleteMapping("/question/delete/{questionId}")//done
	public ResponseEntity<Question> deleteQuestion(@PathVariable long questionId){
		return new ResponseEntity<Question>(userService.deleteQuestion(questionId),HttpStatus.OK);
	}
	@GetMapping("/question/get/{questionId}")//done
	public ResponseEntity<Question> getQuestion(@PathVariable long questionId){
		return new ResponseEntity<Question>(userService.getQuestion(questionId),HttpStatus.OK);
	}
	@GetMapping("/question/getall")//done
	public ResponseEntity<List<Question>> getAllQuestions(){
		return new ResponseEntity<List<Question>>(userService.getAllQuestions(),HttpStatus.OK);
	}
	
	
	
	
	
	
	@PostMapping("/test/add")//done
	public ResponseEntity<Tests> addTest(@RequestBody Tests test){
		return new ResponseEntity<Tests>(userService.addTest(test),HttpStatus.OK);
	}
	@DeleteMapping("/test/delete/id/{testId}")//done
	public ResponseEntity<Tests> deleteTest(@PathVariable long testId){
		return new ResponseEntity<Tests>(userService.deleteTest(testId),HttpStatus.OK);
	}
	@PutMapping("/test/update")
	public ResponseEntity<Tests> updateTest(@RequestBody Tests newTestData){
		System.out.println("controller "+newTestData);
		return new ResponseEntity<Tests>(userService.updateTest(newTestData),HttpStatus.OK);
	}
	@GetMapping("/test/getTest/{testId}")//done
	public ResponseEntity<Tests> getTest(@PathVariable long testId){
		return new ResponseEntity<Tests>(userService.getTest(testId),HttpStatus.OK);
	}
	@GetMapping("/test/fetchall")//done
	public ResponseEntity<List<Tests>> fetchAllTests(){
		return new ResponseEntity<List<Tests>>(userService.fetchAllTests(),HttpStatus.OK);
	}
	@GetMapping("/test/get/question/{testId}")//should be done with question module
	public ResponseEntity<List<Question>> getTestQuestions(@PathVariable long testId){
		return new ResponseEntity<List<Question>>(userService.getTestQuestion(testId),HttpStatus.OK);
	}
	@GetMapping("/test/calculate/marks/{testId}")//should be done with question module
	public ResponseEntity<Double> calculateTotalMarks(@PathVariable long testId){
		return new ResponseEntity<Double>(userService.calculateTotalMarks(testId),HttpStatus.OK);
	}
}

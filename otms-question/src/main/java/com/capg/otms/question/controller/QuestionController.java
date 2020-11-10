/********************************************************************************
 -Author                : Praveen Bandi
 -Created/Modified Date : 23/09/2020
 -Description           : Controller for Performing CRUD Operations On Questions
*********************************************************************************/
package com.capg.otms.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.otms.question.model.Question;
import com.capg.otms.question.service.QuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	
	@PostMapping("/add")
	public Question addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@GetMapping("/get/id/{questionId}")
	public Question getQuestion(@PathVariable long questionId) {
		return questionService.getQuestion(questionId);
	}
	
	@PutMapping("/update")
	public Question updateQuestion(@RequestBody Question question)
	{
		return questionService.updateQuestion(question);
	}
	
	@DeleteMapping("/delete/id/{questionId}")
	public boolean deleteQuestion(@PathVariable long questionId) 
	{
		return questionService.deleteQuestion(questionId);
		
	}
	
	@GetMapping("/getAll")
	public List<Question> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}
}

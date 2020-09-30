package com.capg.otms.question.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.otms.question.model.Question;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class QuestionServiceTest {

	@Autowired
	IQuestionService questionService;

	Question question;
	
	@BeforeAll
	public void setUp()
	{
		List<String> options=new ArrayList<>();
		options.add("long");
		options.add("int");
		options.add("Long");
		options.add("char");
		question=new Question();
		question.setQuestionOptions(options);
		question.setQuestionAnswer(3);
		question.setQuestionTitle("Which is not a primitive data type ?");
		question.setQuestionId(23156742l);
		question.setQuestionMarks(1.0);
	}
	
	@Test()
	@Order(1)
	void testAddQuestion() {
		Question newQuestion=questionService.addQuestion(question);
		assertEquals(question, newQuestion);
	}

	@Test
	@Order(4)
	void testUpdateQuestion() {
		Question newQuestion=question;	
		question.setQuestionMarks(3.0);
		assertEquals(newQuestion,questionService.updateQuestion(question));
	}

	@Test
	@Order(5)
	void testDeleteQuestion() {
		
		assertEquals(true, questionService.deleteQuestion(23156742l));
	}
	
	@Test
	@Order(3)
	void testGetAllQuestions()
	{
		
		List<Question>questionList=questionService.getAllQuestions();
		assertEquals(7,questionList.size());
	}

	@Test
	@Order(2)
	void testGetQuestion()
	{
Question newQuestion=questionService.getQuestion(23156742l);
		assertEquals(question,newQuestion);
	}
}

package com.capg.otms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.otms.model.Tests;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class TestServiceTest {

	@Autowired
	ITestServiceImp testservice;
	
	Tests test;
	
	@BeforeAll
	public void setUp()
	{
		test=new Tests();
		test.setTestId(16211001);
		test.setTestTitle("ILETS");
		test.setTestDuration(LocalTime.of(03, 00, 00));
		Set<Long> questions=new HashSet<Long>();
		questions.add(1L);
		questions.add(2L);
		questions.add(3L);
		questions.add(4L);
		test.setTestQuestions(questions);
		test.setTestTotalMarks(450);
		test.setTestMarksScored(0);
		test.setCurrentQuestion(1);
		test.setStartTime(LocalDateTime.of(2020, 9, 12, 01, 00, 00));
		test.setEndTime(LocalDateTime.of(2020, 9, 12, 04, 00, 00));
		
		
	}
	
	@Test()
	@Order(1)
	void testAddTest() {
		Tests newTest=testservice.addtest(test);
		assertEquals(test, newTest);
	
	}
	
	@Test()
	@Order(2)
	void testDeleteTest() {
		Tests newTest=testservice.getTest(16211001);
		assertEquals(newTest, testservice.deleteTest(16211001));
		
	}
	
	

}

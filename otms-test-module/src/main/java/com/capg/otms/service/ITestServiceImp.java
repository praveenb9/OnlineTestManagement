package com.capg.otms.service;

import java.util.List;

import com.capg.otms.model.Question;
import com.capg.otms.model.Tests;





public interface ITestServiceImp {
	
		
		public Tests addtest(Tests test);
		public Tests updateTest(Tests test);
		public Tests deleteTest(long testId);
		public Tests getTest(long testId);
		public List<Tests> fetchAllTests();
		public List<Question> getTestQuestions(long testId);
		public double calculateTotalMarks(long testId);
	}



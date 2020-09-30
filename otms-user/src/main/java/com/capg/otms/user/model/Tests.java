package com.capg.otms.user.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;


public class Tests {
	private long testId; 
	private String testTitle;
	private LocalTime testDuration;
	private Set<Long> testQuestions;
	private double testTotalMarks;
	private double testMarksScored;
	private long currentQuestion;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
public Tests() {
	
}

public Tests(long testId, String testTitle, LocalTime testDuration, Set<Long> testQuestions, double testTotalMarks,
		double testMarksScored, long currentQuestion, LocalDateTime startTime, LocalDateTime endTime) {
	super();
	this.testId = testId;
	this.testTitle = testTitle;
	this.testDuration = testDuration;
	this.testQuestions = testQuestions;
	this.testTotalMarks = testTotalMarks;
	this.testMarksScored = testMarksScored;
	this.currentQuestion = currentQuestion;
	this.startTime = startTime;
	this.endTime = endTime;
}

public long getTestId() {
	return testId;
}

public void setTestId(long testId) {
	this.testId = testId;
}

public String getTestTitle() {
	return testTitle;
}

public void setTestTitle(String testTitle) {
	this.testTitle = testTitle;
}

public LocalTime getTestDuration() {
	return testDuration;
}

public void setTestDuration(LocalTime testDuration) {
	this.testDuration = testDuration;
}

public Set<Long> getTestQuestions() {
	return testQuestions;
}

public void setTestQuestions(Set<Long> testQuestions) {
	this.testQuestions = testQuestions;
}

public double getTestTotalMarks() {
	return testTotalMarks;
}

public void setTestTotalMarks(double testTotalMarks) {
	this.testTotalMarks = testTotalMarks;
}

public double getTestMarksScored() {
	return testMarksScored;
}

public void setTestMarksScored(double testMarksScored) {
	this.testMarksScored = testMarksScored;
}

public long getCurrentQuestion() {
	return currentQuestion;
}

public void setCurrentQuestion(long currentQuestion) {
	this.currentQuestion = currentQuestion;
}

public LocalDateTime getStartTime() {
	return startTime;
}

public void setStartTime(LocalDateTime startTime) {
	this.startTime = startTime;
}

public LocalDateTime getEndTime() {
	return endTime;
}

public void setEndTime(LocalDateTime endTime) {
	this.endTime = endTime;
}

@Override
public String toString() {
	return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration + ", testQuestions="
			+ testQuestions + ", testTotalMarks=" + testTotalMarks + ", testMarksScored=" + testMarksScored
			+ ", currentQuestion=" + currentQuestion + ", startTime=" + startTime + ", endTime=" + endTime + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (currentQuestion ^ (currentQuestion >>> 32));
	result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
	result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
	result = prime * result + ((testDuration == null) ? 0 : testDuration.hashCode());
	result = prime * result + (int) (testId ^ (testId >>> 32));
	long temp;
	temp = Double.doubleToLongBits(testMarksScored);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((testQuestions == null) ? 0 : testQuestions.hashCode());
	result = prime * result + ((testTitle == null) ? 0 : testTitle.hashCode());
	temp = Double.doubleToLongBits(testTotalMarks);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Tests other = (Tests) obj;
	if (currentQuestion != other.currentQuestion)
		return false;
	if (endTime == null) {
		if (other.endTime != null)
			return false;
	} else if (!endTime.equals(other.endTime))
		return false;
	if (startTime == null) {
		if (other.startTime != null)
			return false;
	} else if (!startTime.equals(other.startTime))
		return false;
	if (testDuration == null) {
		if (other.testDuration != null)
			return false;
	} else if (!testDuration.equals(other.testDuration))
		return false;
	if (testId != other.testId)
		return false;
	if (Double.doubleToLongBits(testMarksScored) != Double.doubleToLongBits(other.testMarksScored))
		return false;
	if (testQuestions == null) {
		if (other.testQuestions != null)
			return false;
	} else if (!testQuestions.equals(other.testQuestions))
		return false;
	if (testTitle == null) {
		if (other.testTitle != null)
			return false;
	} else if (!testTitle.equals(other.testTitle))
		return false;
	if (Double.doubleToLongBits(testTotalMarks) != Double.doubleToLongBits(other.testTotalMarks))
		return false;
	return true;
}


}

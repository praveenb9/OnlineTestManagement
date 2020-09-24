package com.capg.otms.user.model;

import java.util.List;

public class Question {
	
	private long questionId;
	private List<String> questionOptions;
	private String questionTitle;
	private int questionAnswer;
	private double questionMarks;
	private int chosenAnswer;
	private double marksScored;
	public Question() {
		
	}
	public Question(long questionId, List<String> questionOptions, String questionTitle, int questionAnswer,
			double questionMarks, int chosenAnswer, double marksScored) {
		super();
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public List<String> getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(List<String> questionOptions) {
		this.questionOptions = questionOptions;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public double getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(double questionMarks) {
		this.questionMarks = questionMarks;
	}
	public int getChosenAnswer() {
		return chosenAnswer;
	}
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
	public double getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(double marksScored) {
		this.marksScored = marksScored;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionOptions=" + questionOptions + ", questionTitle="
				+ questionTitle + ", questionAnswer=" + questionAnswer + ", questionMarks=" + questionMarks
				+ ", chosenAnswer=" + chosenAnswer + ", marksScored=" + marksScored + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chosenAnswer;
		long temp;
		temp = Double.doubleToLongBits(marksScored);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + questionAnswer;
		result = prime * result + (int) (questionId ^ (questionId >>> 32));
		temp = Double.doubleToLongBits(questionMarks);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((questionOptions == null) ? 0 : questionOptions.hashCode());
		result = prime * result + ((questionTitle == null) ? 0 : questionTitle.hashCode());
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
		Question other = (Question) obj;
		if (chosenAnswer != other.chosenAnswer)
			return false;
		if (Double.doubleToLongBits(marksScored) != Double.doubleToLongBits(other.marksScored))
			return false;
		if (questionAnswer != other.questionAnswer)
			return false;
		if (questionId != other.questionId)
			return false;
		if (Double.doubleToLongBits(questionMarks) != Double.doubleToLongBits(other.questionMarks))
			return false;
		if (questionOptions == null) {
			if (other.questionOptions != null)
				return false;
		} else if (!questionOptions.equals(other.questionOptions))
			return false;
		if (questionTitle == null) {
			if (other.questionTitle != null)
				return false;
		} else if (!questionTitle.equals(other.questionTitle))
			return false;
		return true;
	}
	
	
}

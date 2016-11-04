package org.redborn.csatlatte.domain;

public class CorrectAnswerVo {

	private int questionSequence;
	private int objectItemSequence;
	private String description;
	
	public int getQuestionSequence() {
		return questionSequence;
	}
	
	public void setQuestionSequence(int questionSequence) {
		this.questionSequence = questionSequence;
	}
	
	public int getObjectItemSequence() {
		return objectItemSequence;
	}
	
	public void setObjectItemSequence(int objectItemSequence) {
		this.objectItemSequence = objectItemSequence;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CorrectAnswerVo [questionSequence=" + questionSequence
				+ ", objectItemSequence=" + objectItemSequence
				+ ", description=" + description + "]";
	}
	
}
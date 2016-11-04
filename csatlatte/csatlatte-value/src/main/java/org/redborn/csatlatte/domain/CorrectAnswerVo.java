package org.redborn.csatlatte.domain;

public class CorrectAnswerVo {

	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private int questionSequence;
	private int objectItemSequence;
	private String description;
	
	public int getCsatSequence() {
		return csatSequence;
	}
	
	public void setCsatSequence(int csatSequence) {
		this.csatSequence = csatSequence;
	}
	
	public int getExamSequence() {
		return examSequence;
	}
	
	public void setExamSequence(int examSequence) {
		this.examSequence = examSequence;
	}
	
	public int getSectionSequence() {
		return sectionSequence;
	}
	
	public void setSectionSequence(int sectionSequence) {
		this.sectionSequence = sectionSequence;
	}
	
	public int getSubjectSequence() {
		return subjectSequence;
	}
	
	public void setSubjectSequence(int subjectSequence) {
		this.subjectSequence = subjectSequence;
	}
	
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
		return "CorrectAnswerVo [csatSequence=" + csatSequence
				+ ", examSequence=" + examSequence + ", sectionSequence="
				+ sectionSequence + ", subjectSequence=" + subjectSequence
				+ ", questionSequence=" + questionSequence
				+ ", objectItemSequence=" + objectItemSequence
				+ ", description=" + description + "]";
	}
	
}
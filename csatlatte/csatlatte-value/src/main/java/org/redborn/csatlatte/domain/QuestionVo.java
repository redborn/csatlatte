package org.redborn.csatlatte.domain;

public class QuestionVo {
	
	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private int questionSequence;
	private int questionTypeSequence;
	private int score;
	private String content;
	
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
	
	public int getQuestionTypeSequence() {
		return questionTypeSequence;
	}
	
	public void setQuestionTypeSequence(int questionTypeSequence) {
		this.questionTypeSequence = questionTypeSequence;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "QuestionVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", sectionSequence=" + sectionSequence
				+ ", subjectSequence=" + subjectSequence
				+ ", questionSequence=" + questionSequence
				+ ", questionTypeSequence=" + questionTypeSequence + ", score="
				+ score + ", content=" + content + "]";
	}
}

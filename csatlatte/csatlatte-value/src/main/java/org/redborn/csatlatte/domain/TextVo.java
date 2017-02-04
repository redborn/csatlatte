package org.redborn.csatlatte.domain;

public class TextVo {

	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private int textSequence;
	private int beginQuestionSequence;
	private int endQuestionSequence;
	private String content;
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
	
	public int getTextSequence() {
		return textSequence;
	}
	
	public void setTextSequence(int textSequence) {
		this.textSequence = textSequence;
	}
	
	public int getBeginQuestionSequence() {
		return beginQuestionSequence;
	}
	
	public void setBeginQuestionSequence(int beginQuestionSequence) {
		this.beginQuestionSequence = beginQuestionSequence;
	}
	
	public int getEndQuestionSequence() {
		return endQuestionSequence;
	}
	
	public void setEndQuestionSequence(int endQuestionSequence) {
		this.endQuestionSequence = endQuestionSequence;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "TextVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", sectionSequence=" + sectionSequence
				+ ", subjectSequence=" + subjectSequence + ", textSequence="
				+ textSequence + ", beginQuestionSequence="
				+ beginQuestionSequence + ", endQuestionSequence="
				+ endQuestionSequence + ", content=" + content
				+ ", description=" + description + "]";
	}
	
	

}

package org.redborn.csatlatte.domain;

public class StudentScqsVo {

	private int studentSequence;
	private int scqsSequence;
	private String content;
	
	public int getStudentSequence() {
		return studentSequence;
	}
	
	public void setStudentSequence(int studentSequence) {
		this.studentSequence = studentSequence;
	}
	
	public int getScqsSequence() {
		return scqsSequence;
	}
	
	public void setScqsSequence(int scqsSequence) {
		this.scqsSequence = scqsSequence;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "StudentScqsVo [studentSequence=" + studentSequence + ", scqsSequence="
				+ scqsSequence + ", content=" + content + "]";
	}
	
}

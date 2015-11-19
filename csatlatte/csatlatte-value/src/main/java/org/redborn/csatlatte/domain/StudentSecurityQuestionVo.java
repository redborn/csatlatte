package org.redborn.csatlatte.domain;

public class StudentSecurityQuestionVo {

	private int studentSequence;
	private int securityQuestionSequence;
	private String content;
	
	public int getStudentSequence() {
		return studentSequence;
	}
	
	public void setStudentSequence(int studentSequence) {
		this.studentSequence = studentSequence;
	}
	
	public int getSecurityQuestionSequence() {
		return securityQuestionSequence;
	}
	
	public void setSecurityQuestionSequence(int securityQuestionSequence) {
		this.securityQuestionSequence = securityQuestionSequence;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "StudentSecurityQuestionVo [studentSequence=" + studentSequence + ", securityQuestionSequence="
				+ securityQuestionSequence + ", content=" + content + "]";
	}
	
}

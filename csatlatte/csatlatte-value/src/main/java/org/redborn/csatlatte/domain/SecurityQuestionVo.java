package org.redborn.csatlatte.domain;

public class SecurityQuestionVo {

	private int securityQuestionSequence;
	private String content;
	
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
		return "SecurityQuestionVo [securityQuestionSequence="
				+ securityQuestionSequence + ", content=" + content + "]";
	}
	
}

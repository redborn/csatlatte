package org.redborn.csatlatte.domain;

public class QnaAnswerVo {

	private int qnaSequence;
	private String content;
	
	public int getQnaSequence() {
		return qnaSequence;
	}
	
	public void setQnaSequence(int qnaSequence) {
		this.qnaSequence = qnaSequence;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "QnaAnswerVo [qnaSequence=" + qnaSequence + ", content="
				+ content + "]";
	}
	
}

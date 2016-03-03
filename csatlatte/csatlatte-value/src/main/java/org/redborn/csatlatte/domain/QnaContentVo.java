package org.redborn.csatlatte.domain;

public class QnaContentVo {

	private int qnaSequence;
	private int contentSequence;
	private String content;
	
	public int getQnaSequence() {
		return qnaSequence;
	}
	
	public void setQnaSequence(int qnaSequence) {
		this.qnaSequence = qnaSequence;
	}
	
	public int getContentSequence() {
		return contentSequence;
	}
	
	public void setContentSequence(int contentSequence) {
		this.contentSequence = contentSequence;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "QnaContentVo [qnaSequence=" + qnaSequence
				+ ", contentSequence=" + contentSequence + ", content="
				+ content + "]";
	}
	
}

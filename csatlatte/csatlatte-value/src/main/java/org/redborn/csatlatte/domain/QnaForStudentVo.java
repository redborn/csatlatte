package org.redborn.csatlatte.domain;

public class QnaForStudentVo {
	
	private int qnaSequence;
	private String content;
	private String writeDate;
	
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
	
	public String getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "QnaForStudentVo [qnaSequence=" + qnaSequence + ", content="
				+ content + ", writeDate=" + writeDate + "]";
	}
	
}

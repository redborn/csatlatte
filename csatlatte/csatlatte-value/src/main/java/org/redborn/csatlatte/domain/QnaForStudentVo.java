package org.redborn.csatlatte.domain;

public class QnaForStudentVo {
	
	private int qnaSequence;
	private String title;
	private String writeDate;
	
	public int getQnaSequence() {
		return qnaSequence;
	}
	
	public void setQnaSequence(int qnaSequence) {
		this.qnaSequence = qnaSequence;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "QnaForStudentVo [qnaSequence=" + qnaSequence + ", title="
				+ title + ", writeDate=" + writeDate + "]";
	}
	
}

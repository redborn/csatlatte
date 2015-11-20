package org.redborn.csatlatte.domain;

public class QnaVo {
	
	private int qnaSequence;
	private int studentSequence;
	private String writeDate;
	
	public int getQnaSequence() {
		return qnaSequence;
	}
	
	public void setQnaSequence(int qnaSequence) {
		this.qnaSequence = qnaSequence;
	}
	
	public int getStudentSequence() {
		return studentSequence;
	}
	
	public void setStudentSequence(int studentSequence) {
		this.studentSequence = studentSequence;
	}
	
	public String getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "QnaVo [qnaSequence=" + qnaSequence + ", studentSequence="
				+ studentSequence + ", writeDate=" + writeDate + "]";
	}
	
}

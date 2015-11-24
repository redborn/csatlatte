package org.redborn.csatlatte.domain;

import java.util.List;

public class QnaVo {
	
	private int qnaSequence;
	private int studentSequence;
	private String writeDate;
	private String content;
	private List<QnaFileVo> file;
	
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
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public List<QnaFileVo> getFile() {
		return file;
	}
	
	public void setFile(List<QnaFileVo> file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "QnaVo [qnaSequence=" + qnaSequence + ", studentSequence="
				+ studentSequence + ", writeDate=" + writeDate + ", content="
				+ content + ", file=" + file + "]";
	}
	
}

package org.redborn.csatlatte.domain;

import java.sql.Date;
import java.util.List;

public class QnaVo {
	
	private int qnaSequence;
	private int studentSequence;
	private Date writeDate;
	private String content;
	private List<QnaFileVo> file;
	private String title;
	
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
	
	public Date getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(Date writeDate) {
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "QnaVo [qnaSequence=" + qnaSequence + ", studentSequence="
				+ studentSequence + ", writeDate=" + writeDate + ", content="
				+ content + ", file=" + file + ", title=" + title + "]";
	}

}

package org.redborn.csatlatte.domain;

import java.sql.Date;
import java.util.List;

public class QnaVo {
	
	private int qnaSequence;
	private int studentSequence;
	private Date writeDate;
	private String content;
	private String title;
	private List<FileVo> file;
	
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<FileVo> getFile() {
		return file;
	}

	public void setFile(List<FileVo> file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "QnaVo [qnaSequence=" + qnaSequence + ", studentSequence="
				+ studentSequence + ", writeDate=" + writeDate + ", content="
				+ content + ", title=" + title + ", file=" + file + "]";
	}

}

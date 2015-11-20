package org.redborn.csatlatte.domain;

public class QnaForManageVo {
	
	private int qnaSequence;
	private String studentId;
	private String nickname;
	private String content;
	private String writeDate;
	
	public int getQnaSequence() {
		return qnaSequence;
	}
	
	public void setQnaSequence(int qnaSequence) {
		this.qnaSequence = qnaSequence;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return "QnaForManageVo [qnaSequence=" + qnaSequence + ", studentId="
				+ studentId + ", nickname=" + nickname + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}
	
}

package org.redborn.csatlatte.domain;

public class QnaForManageVo {
	
	private int qnaSequence;
	private String title;
	private String studentId;
	private String nickname;
	private String content;
	private String writeDate;
	private String useYn;
	private int countQnaAnswer;
	
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
	
	public String getUseYn() {
		return useYn;
	}
	
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public int getCountQnaAnswer() {
		return countQnaAnswer;
	}

	public void setCountQnaAnswer(int countQnaAnswer) {
		this.countQnaAnswer = countQnaAnswer;
	}

	@Override
	public String toString() {
		return "QnaForManageVo [qnaSequence=" + qnaSequence + ", title="
				+ title + ", studentId=" + studentId + ", nickname=" + nickname
				+ ", content=" + content + ", writeDate=" + writeDate
				+ ", useYn=" + useYn + ", countQnaAnswer=" + countQnaAnswer
				+ "]";
	}

}

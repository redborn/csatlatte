package org.redborn.csatlatte.domain;

public class CommunityVo {

	private int communitySequence;
	private int studentSequence;
	private String nickname;
	private String content;
	private String writeDate;
	
	public int getCommunitySequence() {
		return communitySequence;
	}
	
	public void setCommunitySequence(int communitySequence) {
		this.communitySequence = communitySequence;
	}
	
	public int getStudentSequence() {
		return studentSequence;
	}
	
	public void setStudentSequence(int studentSequence) {
		this.studentSequence = studentSequence;
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
		return "CommunityVo [communitySequence=" + communitySequence
				+ ", studentSequence=" + studentSequence + ", nickname="
				+ nickname + ", content=" + content + ", writeDate="
				+ writeDate + "]";
	}
	
}

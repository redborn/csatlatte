package org.redborn.csatlatte.domain;

public class CommunityVo {

	private int communityTypeSequence;
	private int communitySequence;
	private int studentSequence;
	private String studentId;
	private String nickname;
	private String content;
	private String writeDate;
	private int blind;
	
	public int getCommunityTypeSequence() {
		return communityTypeSequence;
	}

	public void setCommunityTypeSequence(int communityTypeSequence) {
		this.communityTypeSequence = communityTypeSequence;
	}

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
	
	public int getBlind() {
		return blind;
	}
	
	public void setBlind(int blind) {
		this.blind = blind;
	}

	@Override
	public String toString() {
		return "CommunityVo [communityTypeSequence=" + communityTypeSequence
				+ ", communitySequence=" + communitySequence
				+ ", studentSequence=" + studentSequence + ", studentId="
				+ studentId + ", nickname=" + nickname + ", content=" + content
				+ ", writeDate=" + writeDate + ", blind=" + blind + "]";
	}
	
}

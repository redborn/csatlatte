package org.redborn.csatlatte.domain;

public class CommunityVo {

	private int communitySequence;
	private String nickname;
	private int content;
	private int writeDate;
	
	public int getCommunitySequence() {
		return communitySequence;
	}
	
	public void setCommunitySequence(int communitySequence) {
		this.communitySequence = communitySequence;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public int getContent() {
		return content;
	}
	
	public void setContent(int content) {
		this.content = content;
	}
	
	public int getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(int writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "CommunityVo [communitySequence=" + communitySequence
				+ ", nickname=" + nickname + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}
	
}

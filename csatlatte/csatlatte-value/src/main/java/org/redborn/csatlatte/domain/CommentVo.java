package org.redborn.csatlatte.domain;

public class CommentVo {
	
	private int communitySequence;
	private int commentSequence;
	private String nickname;
	private String content;
	private String writeDate;
	
	public int getCommunitySequence() {
		return communitySequence;
	}
	
	public void setCommunitySequence(int communitySequence) {
		this.communitySequence = communitySequence;
	}
	
	public int getCommentSequence() {
		return commentSequence;
	}
	
	public void setCommentSequence(int commentSequence) {
		this.commentSequence = commentSequence;
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
		return "CommentVo [communitySequence=" + communitySequence
				+ ", commentSequence=" + commentSequence + ", nickname="
				+ nickname + ", content=" + content + ", writeDate="
				+ writeDate + "]";
	}
	
}

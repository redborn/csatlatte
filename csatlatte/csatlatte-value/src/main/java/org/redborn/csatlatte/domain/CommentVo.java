package org.redborn.csatlatte.domain;

public class CommentVo {
	
	private int communitySequence;
	private int commentSequence;
	private int studentSequence;
	private String content;
	
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
	
	public int getStudentSequence() {
		return studentSequence;
	}
	
	public void setStudentSequence(int studentSequence) {
		this.studentSequence = studentSequence;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "CommentVo [communitySequence=" + communitySequence
				+ ", commentSequence=" + commentSequence + ", studentSequence="
				+ studentSequence + ", content=" + content + "]";
	}
	
}

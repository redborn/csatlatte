package org.redborn.csatlatte.domain;

public class CommentVo {

	private int communityTypeSequence;
	private int communitySequence;
	private int commentSequence;
	private int studentSequence;
	private String nickname;
	private String content;
	private String writeYmdhms;

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

	public String getWriteYmdhms() {
		return writeYmdhms;
	}

	public void setWriteYmdhms(String writeYmdhms) {
		this.writeYmdhms = writeYmdhms;
	}

	@Override
	public String toString() {
		return "CommentVo [communityTypeSequence=" + communityTypeSequence
				+ ", communitySequence=" + communitySequence
				+ ", commentSequence=" + commentSequence + ", studentSequence="
				+ studentSequence + ", nickname=" + nickname + ", content="
				+ content + ", writeYmdhms=" + writeYmdhms + "]";
	}

}

package org.redborn.csatlatte.domain;

public class CommentVo {

	private int communityTypeSequence;
	private int communitySequence;
	private int commentSequence;
	private int studentSequence;
	private String nickname;
	private String content;
	private boolean report;
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

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}

	public String getWriteYmdhms() {
		return writeYmdhms;
	}

	public void setWriteYmdhms(String writeYmdhms) {
		this.writeYmdhms = writeYmdhms;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommentVo [communityTypeSequence=");
		builder.append(communityTypeSequence);
		builder.append(", communitySequence=");
		builder.append(communitySequence);
		builder.append(", commentSequence=");
		builder.append(commentSequence);
		builder.append(", studentSequence=");
		builder.append(studentSequence);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", content=");
		builder.append(content);
		builder.append(", report=");
		builder.append(report);
		builder.append(", writeYmdhms=");
		builder.append(writeYmdhms);
		builder.append("]");
		return builder.toString();
	}

}

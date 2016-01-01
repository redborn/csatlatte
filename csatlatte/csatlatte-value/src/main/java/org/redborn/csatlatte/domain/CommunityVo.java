package org.redborn.csatlatte.domain;

public class CommunityVo {

	private int communityTypeSequence;
	private int communitySequence;
	private int studentSequence;
	private String studentId;
	private String nickname;
	private String content;
	private String writeYmdhms;
	private boolean report;
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

	public String getWriteYmdhms() {
		return writeYmdhms;
	}

	public void setWriteYmdhms(String writeYmdhms) {
		this.writeYmdhms = writeYmdhms;
	}

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}

	public int getBlind() {
		return blind;
	}

	public void setBlind(int blind) {
		this.blind = blind;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommunityVo [communityTypeSequence=");
		builder.append(communityTypeSequence);
		builder.append(", communitySequence=");
		builder.append(communitySequence);
		builder.append(", studentSequence=");
		builder.append(studentSequence);
		builder.append(", studentId=");
		builder.append(studentId);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", content=");
		builder.append(content);
		builder.append(", writeYmdhms=");
		builder.append(writeYmdhms);
		builder.append(", report=");
		builder.append(report);
		builder.append(", blind=");
		builder.append(blind);
		builder.append("]");
		return builder.toString();
	}

}

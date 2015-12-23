package org.redborn.csatlatte.domain;

public class StudentVo {

	private int studentSequence;
	private String studentId;
	private String studentPassword;
	private String nickname;
	private String photoCode;
	private String photoName;
	private int csatSequence;
	private String useYn;
	private String createDate;
	private int countConnection;
	private int averageScore;
	private String securityQuestionContent;
	private String csatName;
	private int countCommunity;
	private int countComment;
	private String lastConnection;
	
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
	
	public String getStudentPassword() {
		return studentPassword;
	}
	
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPhotoCode() {
		return photoCode;
	}
	
	public void setPhotoCode(String photoCode) {
		this.photoCode = photoCode;
	}
	
	public String getPhotoName() {
		return photoName;
	}
	
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	public int getCsatSequence() {
		return csatSequence;
	}
	
	public void setCsatSequence(int csatSequence) {
		this.csatSequence = csatSequence;
	}
	
	public String getUseYn() {
		return useYn;
	}
	
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public int getCountConnection() {
		return countConnection;
	}
	
	public void setCountConnection(int countConnection) {
		this.countConnection = countConnection;
	}
	
	public int getAverageScore() {
		return averageScore;
	}
	
	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}
	
	public String getSecurityQuestionContent() {
		return securityQuestionContent;
	}

	public void setSecurityQuestionContent(String securityQuestionContent) {
		this.securityQuestionContent = securityQuestionContent;
	}

	public String getCsatName() {
		return csatName;
	}

	public void setCsatName(String csatName) {
		this.csatName = csatName;
	}

	public int getCountCommunity() {
		return countCommunity;
	}

	public void setCountCommunity(int countCommunity) {
		this.countCommunity = countCommunity;
	}

	public int getCountComment() {
		return countComment;
	}

	public void setCountComment(int countComment) {
		this.countComment = countComment;
	}

	public String getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(String lastConnection) {
		this.lastConnection = lastConnection;
	}

	@Override
	public String toString() {
		return "StudentVo [studentSequence=" + studentSequence + ", studentId="
				+ studentId + ", studentPassword=" + studentPassword
				+ ", nickname=" + nickname + ", photoCode=" + photoCode
				+ ", photoName=" + photoName + ", csatSequence=" + csatSequence
				+ ", useYn=" + useYn + ", createDate=" + createDate
				+ ", countConnection=" + countConnection + ", averageScore="
				+ averageScore + ", securityQuestionContent="
				+ securityQuestionContent + ", csatName=" + csatName
				+ ", countCommunity=" + countCommunity + ", countComment="
				+ countComment + ", lastConnection=" + lastConnection + "]";
	}

}

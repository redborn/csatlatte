package org.redborn.csatlatte.domain;

public class StudentInformationVo {

	private String studentId;
	private String securityQuestionContent;
	private String photoCode;
	private String photoName;
	private String nickname;
	private String csatName;
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getSecurityQuestionContent() {
		return securityQuestionContent;
	}
	
	public void setSecurityQuestionContent(String securityQuestionContent) {
		this.securityQuestionContent = securityQuestionContent;
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
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getCsatName() {
		return csatName;
	}
	
	public void setCsatName(String csatName) {
		this.csatName = csatName;
	}
	
	@Override
	public String toString() {
		return "StudentInformationVo [studentId=" + studentId
				+ ", securityQuestionContent=" + securityQuestionContent
				+ ", photoCode=" + photoCode + ", photoName=" + photoName
				+ ", nickname=" + nickname + ", csatName=" + csatName + "]";
	}
	
}

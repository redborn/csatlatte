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
	
	@Override
	public String toString() {
		return "StudentVo [studentSequence=" + studentSequence + ", studentId="
				+ studentId + ", studentPassword=" + studentPassword + ", nickname="
				+ nickname + ", photoCode=" + photoCode + ", photoName="
				+ photoName + ", csatSequence=" + csatSequence + ", useYn="
				+ useYn + ", createDate=" + createDate + "]";
	}
	
}
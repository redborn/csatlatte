package org.redborn.csatlatte.domain;

public class ExamVo {

	private int csatSequence;
	private int examSequence;
	private int manageSequence;
	private int ysSequence;
	private String ymd;
	private String year;
	private String examName;
	private String manageName;
	
	public int getCsatSequence() {
		return csatSequence;
	}
	
	public void setCsatSequence(int csatSequence) {
		this.csatSequence = csatSequence;
	}
	
	public int getExamSequence() {
		return examSequence;
	}

	public void setExamSequence(int examSequence) {
		this.examSequence = examSequence;
	}
	
	public int getManageSequence() {
		return manageSequence;
	}
	
	public void setManageSequence(int manageSequence) {
		this.manageSequence = manageSequence;
	}
	
	public int getYsSequence() {
		return ysSequence;
	}
	
	public void setYsSequence(int ysSequence) {
		this.ysSequence = ysSequence;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	public String getYmd() {
		return ymd;
	}
	
	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	@Override
	public String toString() {
		return "ExamVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", manageSequence=" + manageSequence
				+ ", ysSequence=" + ysSequence + ", ymd=" + ymd + ", year="
				+ year + ", examName=" + examName + ", manageName="
				+ manageName + "]";
	}

}

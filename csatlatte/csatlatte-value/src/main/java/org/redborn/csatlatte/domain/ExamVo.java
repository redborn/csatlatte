package org.redborn.csatlatte.domain;

public class ExamVo {

	private int csatSequence;
	private int examSequence;
	private int institutionSequence;
	private int ysSequence;
	private String ymd;
	private String year;
	private String examName;
	private String institutionName;
	
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
	
	public int getInstitutionSequence() {
		return institutionSequence;
	}
	
	public void setInstitutionSequence(int institutionSequence) {
		this.institutionSequence = institutionSequence;
	}
	
	public int getYsSequence() {
		return ysSequence;
	}
	
	public void setYsSequence(int ysSequence) {
		this.ysSequence = ysSequence;
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
	
	public String getExamName() {
		return examName;
	}
	
	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}
	
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	
	@Override
	public String toString() {
		return "ExamVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", institutionSequence=" + institutionSequence
				+ ", ysSequence=" + ysSequence + ", ymd=" + ymd + ", year="
				+ year + ", examName=" + examName + ", institutionName="
				+ institutionName + "]";
	}
	
}

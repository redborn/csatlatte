package org.redborn.csatlatte.domain;

public class ExamVo {

	private int csatSequence;
	private int examSequence;
	private int istttSequence;
	private int ysSequence;
	private String ymd;
	private String year;
	private String examName;
	private String istttName;
	
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
	
	public int getIstttSequence() {
		return istttSequence;
	}
	
	public void setIstttSequence(int istttSequence) {
		this.istttSequence = istttSequence;
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

	public String getIstttName() {
		return istttName;
	}

	public void setIstttName(String istttName) {
		this.istttName = istttName;
	}

	@Override
	public String toString() {
		return "ExamVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", istttSequence=" + istttSequence
				+ ", ysSequence=" + ysSequence + ", ymd=" + ymd + ", year="
				+ year + ", examName=" + examName + ", istttName=" + istttName
				+ "]";
	}

}

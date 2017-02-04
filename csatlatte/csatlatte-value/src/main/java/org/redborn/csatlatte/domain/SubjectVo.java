package org.redborn.csatlatte.domain;

public class SubjectVo {

	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private String subjectName;
	private int maxScore;
	private int examTime;
	
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
	
	public int getSectionSequence() {
		return sectionSequence;
	}
	
	public void setSectionSequence(int sectionSequence) {
		this.sectionSequence = sectionSequence;
	}
	
	public int getSubjectSequence() {
		return subjectSequence;
	}
	
	public void setSubjectSequence(int subjectSequence) {
		this.subjectSequence = subjectSequence;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	
	public int getExamTime() {
		return examTime;
	}
	
	public void setExamTime(int examTime) {
		this.examTime = examTime;
	}

	@Override
	public String toString() {
		return "SubjectVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", sectionSequence=" + sectionSequence
				+ ", subjectSequence=" + subjectSequence + ", subjectName="
				+ subjectName + ", maxScore=" + maxScore + ", examTime="
				+ examTime + "]";
	}
	
}

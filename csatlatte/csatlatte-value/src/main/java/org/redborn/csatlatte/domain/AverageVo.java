package org.redborn.csatlatte.domain;

public class AverageVo {

	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private float average;
	private float standardDeviation;
	private String subjectName;
	
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
	
	public float getAverage() {
		return average;
	}
	
	public void setAverage(float average) {
		this.average = average;
	}
	
	public float getStandardDeviation() {
		return standardDeviation;
	}
	
	public void setStandardDeviation(float standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "AverageVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", sectionSequence=" + sectionSequence
				+ ", subjectSequence=" + subjectSequence + ", average="
				+ average + ", standardDeviation=" + standardDeviation
				+ ", subjectName=" + subjectName + "]";
	}

}

package org.redborn.csatlatte.domain;

public class RatingCutVo {

	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private int rawScore;
	private int ratingCode;
	private int standardScore;
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
	
	public int getRawScore() {
		return rawScore;
	}
	
	public void setRawScore(int rawScore) {
		this.rawScore = rawScore;
	}
	
	public int getRatingCode() {
		return ratingCode;
	}

	public void setRatingCode(int ratingCode) {
		this.ratingCode = ratingCode;
	}

	public int getStandardScore() {
		return standardScore;
	}
	
	public void setStandardScore(int standardScore) {
		this.standardScore = standardScore;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "RatingCutVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", sectionSequence=" + sectionSequence
				+ ", subjectSequence=" + subjectSequence + ", rawScore="
				+ rawScore + ", ratingCode=" + ratingCode + ", standardScore="
				+ standardScore + ", subjectName=" + subjectName + "]";
	}
	
}

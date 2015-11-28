package org.redborn.csatlatte.domain;

public class RatingCutVo {

	private int csatSequence;
	private int ratingCode;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private int rawScore;
	private int standardScore;
	private int average;
	private int standardDeviation;
	
	public int getCsatSequence() {
		return csatSequence;
	}
	
	public void setCsatSequence(int csatSequence) {
		this.csatSequence = csatSequence;
	}
	
	public int getRatingCode() {
		return ratingCode;
	}
	
	public void setRatingCode(int ratingCode) {
		this.ratingCode = ratingCode;
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
	
	public int getStandardScore() {
		return standardScore;
	}
	
	public void setStandardScore(int standardScore) {
		this.standardScore = standardScore;
	}
	
	public int getAverage() {
		return average;
	}
	
	public void setAverage(int average) {
		this.average = average;
	}
	
	public int getStandardDeviation() {
		return standardDeviation;
	}
	
	public void setStandardDeviation(int standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	@Override
	public String toString() {
		return "RatingCutVo [csatSequence=" + csatSequence + ", ratingCode="
				+ ratingCode + ", examSequence=" + examSequence
				+ ", sectionSequence=" + sectionSequence + ", subjectSequence="
				+ subjectSequence + ", rawScore=" + rawScore
				+ ", standardScore=" + standardScore + ", average=" + average
				+ ", standardDeviation=" + standardDeviation + "]";
	}
	
}

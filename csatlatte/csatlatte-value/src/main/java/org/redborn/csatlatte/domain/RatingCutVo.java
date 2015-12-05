package org.redborn.csatlatte.domain;

public class RatingCutVo {

	private int sectionSequence;
	private int subjectSequence;
	private int rawScore;
	private int rating_code;
	private int standardScore;
	
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
	
	public int getRating_code() {
		return rating_code;
	}
	
	public void setRating_code(int rating_code) {
		this.rating_code = rating_code;
	}
	
	public int getStandardScore() {
		return standardScore;
	}
	
	public void setStandardScore(int standardScore) {
		this.standardScore = standardScore;
	}
	
	@Override
	public String toString() {
		return "RatingCut [sectionSequence=" + sectionSequence
				+ ", subjectSequence=" + subjectSequence + ", rawScore="
				+ rawScore + ", rating_code=" + rating_code
				+ ", standardScore=" + standardScore + "]";
	}
	
}

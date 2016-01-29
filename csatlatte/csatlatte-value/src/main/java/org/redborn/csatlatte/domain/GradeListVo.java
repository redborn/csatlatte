package org.redborn.csatlatte.domain;

public class GradeListVo {

	private int sectionSequence;
	private int subjectSequence;
	private String subjectName;
	private int score;
	private int standardScore;
	private String ratingCode;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getStandardScore() {
		return standardScore;
	}

	public void setStandardScore(int standardScore) {
		this.standardScore = standardScore;
	}

	public String getRatingCode() {
		return ratingCode;
	}

	public void setRatingCode(String ratingCode) {
		this.ratingCode = ratingCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GradeListVo [sectionSequence=");
		builder.append(sectionSequence);
		builder.append(", subjectSequence=");
		builder.append(subjectSequence);
		builder.append(", subjectName=");
		builder.append(subjectName);
		builder.append(", score=");
		builder.append(score);
		builder.append(", standardScore=");
		builder.append(standardScore);
		builder.append(", ratingCode=");
		builder.append(ratingCode);
		builder.append("]");
		return builder.toString();
	}

}
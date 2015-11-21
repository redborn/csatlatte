package org.redborn.csatlatte.domain;

public class GradeStandardscoreVo {

	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private int score;
	private int standardscore;
	
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
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getStandardscore() {
		return standardscore;
	}
	
	public void setStandardscore(int standardscore) {
		this.standardscore = standardscore;
	}
	
	@Override
	public String toString() {
		return "GradeStandardscoreVo [csatSequence=" + csatSequence
				+ ", examSequence=" + examSequence + ", sectionSequence="
				+ sectionSequence + ", subjectSequence=" + subjectSequence
				+ ", score=" + score + ", standardscore=" + standardscore + "]";
	}
	
}

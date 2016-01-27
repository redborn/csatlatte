package org.redborn.csatlatte.domain;

public class SectionVo {
	
	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private String sectionName;
	
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
	
	public String getSectionName() {
		return sectionName;
	}
	
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	@Override
	public String toString() {
		return "SectionVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", sectionSequence=" + sectionSequence
				+ ", sectionName=" + sectionName + "]";
	}
	
}

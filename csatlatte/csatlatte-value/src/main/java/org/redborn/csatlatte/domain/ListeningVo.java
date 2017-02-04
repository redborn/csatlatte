package org.redborn.csatlatte.domain;

public class ListeningVo {

	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private String fileCode;
	private String fileName;
	
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
	
	public String getFileCode() {
		return fileCode;
	}
	
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "ListenVo [csatSequence=" + csatSequence + ", examSequence="
				+ examSequence + ", sectionSequence=" + sectionSequence
				+ ", subjectSequence=" + subjectSequence + ", fileCode="
				+ fileCode + ", fileName=" + fileName + "]";
	}
	
}

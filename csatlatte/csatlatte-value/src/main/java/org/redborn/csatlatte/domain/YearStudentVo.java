package org.redborn.csatlatte.domain;

public class YearStudentVo {
	
	private int yearStudentSequence;
	private String yearStudentName;
	
	public int getYearStudentSequence() {
		return yearStudentSequence;
	}
	
	public void setYearStudentSequence(int yearStudentSequence) {
		this.yearStudentSequence = yearStudentSequence;
	}
	
	public String getYearStudentName() {
		return yearStudentName;
	}
	
	public void setYearStudentName(String yearStudentName) {
		this.yearStudentName = yearStudentName;
	}
	
	@Override
	public String toString() {
		return "YearStudentVo [yearStudentSequence=" + yearStudentSequence
				+ ", yearStudentName=" + yearStudentName + "]";
	}
	
}

package org.redborn.csatlatte.domain;

public class ExamDDayVo {

	private int dDay;
	private String examName;
	
	public int getdDay() {
		return dDay;
	}
	
	public void setdDay(int dDay) {
		this.dDay = dDay;
	}
	
	public String getExamName() {
		return examName;
	}
	
	public void setExamName(String examName) {
		this.examName = examName;
	}

	@Override
	public String toString() {
		return "ExamDDayVo [dDay=" + dDay + ", examName=" + examName + "]";
	}
	
}

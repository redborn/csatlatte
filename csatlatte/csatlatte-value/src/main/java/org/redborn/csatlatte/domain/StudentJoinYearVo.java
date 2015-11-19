package org.redborn.csatlatte.domain;

public class StudentJoinYearVo {

	private String year;
	private int countJoin;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public int getCountJoin() {
		return countJoin;
	}
	
	public void setCountJoin(int countJoin) {
		this.countJoin = countJoin;
	}
	
	@Override
	public String toString() {
		return "StudentJoinYearVo [year=" + year + ", countJoin=" + countJoin
				+ "]";
	}
	
}

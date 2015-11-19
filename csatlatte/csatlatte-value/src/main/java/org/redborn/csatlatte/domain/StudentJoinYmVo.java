package org.redborn.csatlatte.domain;

public class StudentJoinYmVo {

	private String day;
	private int countJoin;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public int getCountJoin() {
		return countJoin;
	}
	
	public void setCountJoin(int countJoin) {
		this.countJoin = countJoin;
	}
	
	@Override
	public String toString() {
		return "StudentJoinYmVo [day=" + day + ", countJoin=" + countJoin + "]";
	}
	
}

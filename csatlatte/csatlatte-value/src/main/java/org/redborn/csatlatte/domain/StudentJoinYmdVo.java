package org.redborn.csatlatte.domain;

public class StudentJoinYmdVo {

	private String hour;
	private int countJoin;
	
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public int getCountJoin() {
		return countJoin;
	}
	
	public void setCountJoin(int countJoin) {
		this.countJoin = countJoin;
	}
	
	@Override
	public String toString() {
		return "StudentJoinYmdVo [hour=" + hour + ", countJoin=" + countJoin
				+ "]";
	}
	
}

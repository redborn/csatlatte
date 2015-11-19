package org.redborn.csatlatte.domain;

public class StudentConnectionYmVo {

	private String day;
	private int countConnection;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public int getCountConnection() {
		return countConnection;
	}
	
	public void setCountConnection(int countConnection) {
		this.countConnection = countConnection;
	}
	
	@Override
	public String toString() {
		return "StudentConnectionYmVo [day=" + day + ", countConnection="
				+ countConnection + "]";
	}
	
}

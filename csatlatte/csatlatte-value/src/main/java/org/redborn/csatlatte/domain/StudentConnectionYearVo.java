package org.redborn.csatlatte.domain;

public class StudentConnectionYearVo {

	private String month;
	private int countConnection;
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public int getCountConnection() {
		return countConnection;
	}
	
	public void setCountConnection(int countConnection) {
		this.countConnection = countConnection;
	}
	
	@Override
	public String toString() {
		return "StudentConnectionYearVo [month=" + month + ", countConnection="
				+ countConnection + "]";
	}
	
}

package org.redborn.csatlatte.domain;

public class StudentConnectionYmVo {

	private String day;
	private int count_connection;
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public int getCount_connection() {
		return count_connection;
	}
	
	public void setCount_connection(int count_connection) {
		this.count_connection = count_connection;
	}
	
	@Override
	public String toString() {
		return "StudentConnectionYmVo [day=" + day + ", count_connection="
				+ count_connection + "]";
	}
	
}

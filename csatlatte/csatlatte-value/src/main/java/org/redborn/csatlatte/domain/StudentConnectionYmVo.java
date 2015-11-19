package org.redborn.csatlatte.domain;

public class StudentConnectionYmVo {

	private String day;
	private String count_connection;
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public String getCount_connection() {
		return count_connection;
	}
	
	public void setCount_connection(String count_connection) {
		this.count_connection = count_connection;
	}

	@Override
	public String toString() {
		return "StudentConnectionYmVo [day=" + day + ", count_connection="
				+ count_connection + "]";
	}
	
}

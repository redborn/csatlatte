package org.redborn.csatlatte.domain;

public class StudentConnectionYmdVo {

	private String hour;
	private int count_connection;
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public int getCount_connection() {
		return count_connection;
	}
	
	public void setCount_connection(int count_connection) {
		this.count_connection = count_connection;
	}
	
	@Override
	public String toString() {
		return "StudentConnectionYmdVo [hour=" + hour + ", count_connection="
				+ count_connection + "]";
	}
	
}

package org.redborn.csatlatte.domain;

public class StudentConnectionYmdVo {

	private String hour;
	private String count_connection;
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public String getCount_connection() {
		return count_connection;
	}
	
	public void setCount_connection(String count_connection) {
		this.count_connection = count_connection;
	}
	
	@Override
	public String toString() {
		return "StudentConnectionYmdVo [hour=" + hour + ", count_connection="
				+ count_connection + "]";
	}
	
}

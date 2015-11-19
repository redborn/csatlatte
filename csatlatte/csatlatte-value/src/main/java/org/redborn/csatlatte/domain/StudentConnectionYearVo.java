package org.redborn.csatlatte.domain;

public class StudentConnectionYearVo {

	private String month;
	private String count_connection;
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getCount_connection() {
		return count_connection;
	}
	
	public void setCount_connection(String count_connection) {
		this.count_connection = count_connection;
	}
	
	@Override
	public String toString() {
		return "StudentConnectionYearVo [month=" + month
				+ ", count_connection=" + count_connection + "]";
	}
	
}

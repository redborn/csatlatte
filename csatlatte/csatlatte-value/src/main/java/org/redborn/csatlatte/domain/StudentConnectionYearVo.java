package org.redborn.csatlatte.domain;

public class StudentConnectionYearVo {

	private String month;
	private int count_connection;
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	public int getCount_connection() {
		return count_connection;
	}
	
	public void setCount_connection(int count_connection) {
		this.count_connection = count_connection;
	}
	
	@Override
	public String toString() {
		return "StudentConnectionYearVo [month=" + month
				+ ", count_connection=" + count_connection + "]";
	}
	
}

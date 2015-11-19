package org.redborn.csatlatte.domain;

public class YmCountVo {

	private String day;
	private int count;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "StudentYmVo [day=" + day + ", count=" + count + "]";
	}
	
}

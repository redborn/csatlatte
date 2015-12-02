package org.redborn.csatlatte.domain;

public class YmCountVo {

	private int day;
	private int count;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
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

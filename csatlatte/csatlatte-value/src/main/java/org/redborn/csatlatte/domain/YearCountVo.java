package org.redborn.csatlatte.domain;

public class YearCountVo {

	private int month;
	private int count;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "StudentYearVo [month=" + month + ", count=" + count
				+ "]";
	}
	
}

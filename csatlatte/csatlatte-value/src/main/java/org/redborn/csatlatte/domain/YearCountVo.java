package org.redborn.csatlatte.domain;

public class YearCountVo {

	private String year;
	private int count;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "StudentYearVo [year=" + year + ", count=" + count
				+ "]";
	}
	
}

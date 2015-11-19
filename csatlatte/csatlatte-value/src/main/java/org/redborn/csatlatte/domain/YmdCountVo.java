package org.redborn.csatlatte.domain;

public class YmdCountVo {

	private String hour;
	private int count;
	
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "StudentYmdVo [hour=" + hour + ", count=" + count
				+ "]";
	}
	
}

package org.redborn.csatlatte.domain;

public class StudentConnectionYmdVo {

	private String hour;
	private int countConnection;
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public int getCountConnection() {
		return countConnection;
	}
	
	public void setCountConnection(int countConnection) {
		this.countConnection = countConnection;
	}
	
	@Override
	public String toString() {
		return "StudentConnectionYmdVo [hour=" + hour + ", countConnection="
				+ countConnection + "]";
	}
	
}

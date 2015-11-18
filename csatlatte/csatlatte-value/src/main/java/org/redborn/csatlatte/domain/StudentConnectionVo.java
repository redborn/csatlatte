package org.redborn.csatlatte.domain;

public class StudentConnectionVo {

	private int connectionSequence;
	private int studentSequence;
	private String connectionDate;
	
	public int getConnectionSequence() {
		return connectionSequence;
	}
	
	public void setConnectionSequence(int connectionSequence) {
		this.connectionSequence = connectionSequence;
	}
	
	public int getStudentSequence() {
		return studentSequence;
	}
	
	public void setStudentSequence(int studentSequence) {
		this.studentSequence = studentSequence;
	}
	
	public String getConnectionDate() {
		return connectionDate;
	}
	
	public void setConnectionDate(String connectionDate) {
		this.connectionDate = connectionDate;
	}
	
	@Override
	public String toString() {
		return "StudentConnectionVo [connectionSequence=" + connectionSequence + ", studentSequence="
				+ studentSequence + ", connectionDate=" + connectionDate + "]";
	}
	
}

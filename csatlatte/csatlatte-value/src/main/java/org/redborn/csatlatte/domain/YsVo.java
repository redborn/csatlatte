package org.redborn.csatlatte.domain;

public class YsVo {
	
	private int ysSequence;
	private String ysName;
	
	public int getYsSequence() {
		return ysSequence;
	}
	
	public void setYsSequence(int ysSequence) {
		this.ysSequence = ysSequence;
	}
	
	public String getYsName() {
		return ysName;
	}
	
	public void setYsName(String ysName) {
		this.ysName = ysName;
	}
	
	@Override
	public String toString() {
		return "YsVo [ysSequence=" + ysSequence + ", ysName=" + ysName + "]";
	}
	
}

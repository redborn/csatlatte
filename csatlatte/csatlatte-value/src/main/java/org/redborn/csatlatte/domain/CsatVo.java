package org.redborn.csatlatte.domain;

public class CsatVo {
	private int csatSequence;
	private String csatName;
	
	public int getCsatSequence() {
		return csatSequence;
	}
	
	public void setCsatSequence(int csatSequence) {
		this.csatSequence = csatSequence;
	}
	
	public String getCsatName() {
		return csatName;
	}
	
	public void setCsatName(String csatName) {
		this.csatName = csatName;
	}
	
	@Override
	public String toString() {
		return "CsatVo [csatSequence=" + csatSequence + ", csatName="
				+ csatName + "]";
	}
	
}

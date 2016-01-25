package org.redborn.csatlatte.domain;

public class CsatVo {
	
	private int csatSequence;
	private String csatName;
	private String examYmd;
	
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
	
	public String getExamYmd() {
		return examYmd;
	}

	public void setExamYmd(String examYmd) {
		this.examYmd = examYmd;
	}

	@Override
	public String toString() {
		return "CsatVo [csatSequence=" + csatSequence + ", csatName="
				+ csatName + ", examYmd=" + examYmd + "]";
	}
	
}
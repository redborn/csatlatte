package org.redborn.csatlatte.domain;

public class CsatVo {
	private int csatSequence;
	private String csatName;
	private String useYn;
	
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
	
	public String getUseYn() {
		return useYn;
	}
	
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	
	@Override
	public String toString() {
		return "CsatVo [csatSequence=" + csatSequence + ", csatName="
				+ csatName + " useYn=" + useYn + "]";
	}
	
}

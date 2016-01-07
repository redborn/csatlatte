package org.redborn.csatlatte.domain;

public class IstttVo {
	
	private int istttSequence;
	private String istttName;
	
	public int getIstttSequence() {
		return istttSequence;
	}
	
	public void setIstttSequence(int istttSequence) {
		this.istttSequence = istttSequence;
	}
	
	public String getIstttName() {
		return istttName;
	}
	
	public void setIstttName(String istttName) {
		this.istttName = istttName;
	}

	@Override
	public String toString() {
		return "IstttVo [istttSequence=" + istttSequence + ", istttName="
				+ istttName + "]";
	}
	
}

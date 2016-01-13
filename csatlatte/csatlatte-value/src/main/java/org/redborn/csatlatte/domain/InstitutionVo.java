package org.redborn.csatlatte.domain;

public class InstitutionVo {
	
	private int institutionSequence;
	private String institutionName;
	
	public int getInstitutionSequence() {
		return institutionSequence;
	}
	
	public void setInstitutionSequence(int institutionSequence) {
		this.institutionSequence = institutionSequence;
	}
	
	public String getInstitutionName() {
		return institutionName;
	}
	
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	
	@Override
	public String toString() {
		return "InstitutionVo [institutionSequence=" + institutionSequence
				+ ", institutionName=" + institutionName + "]";
	}
	
}

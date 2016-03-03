package org.redborn.csatlatte.domain;

public class SectionVo {

	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private String sectionName;
	private int selectCount;

	public int getCsatSequence() {
		return csatSequence;
	}

	public void setCsatSequence(int csatSequence) {
		this.csatSequence = csatSequence;
	}

	public int getExamSequence() {
		return examSequence;
	}

	public void setExamSequence(int examSequence) {
		this.examSequence = examSequence;
	}

	public int getSectionSequence() {
		return sectionSequence;
	}

	public void setSectionSequence(int sectionSequence) {
		this.sectionSequence = sectionSequence;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public int getSelectCount() {
		return selectCount;
	}

	public void setSelectCount(int selectCount) {
		this.selectCount = selectCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SectionVo [csatSequence=");
		builder.append(csatSequence);
		builder.append(", examSequence=");
		builder.append(examSequence);
		builder.append(", sectionSequence=");
		builder.append(sectionSequence);
		builder.append(", sectionName=");
		builder.append(sectionName);
		builder.append(", selectCount=");
		builder.append(selectCount);
		builder.append("]");
		return builder.toString();
	}

}

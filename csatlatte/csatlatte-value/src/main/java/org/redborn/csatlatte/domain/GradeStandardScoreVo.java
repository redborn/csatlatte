package org.redborn.csatlatte.domain;

public class GradeStandardScoreVo {

	private String examName;
	private int standardScoreSum;

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public int getStandardScoreSum() {
		return standardScoreSum;
	}

	public void setStandardScoreSum(int standardScoreSum) {
		this.standardScoreSum = standardScoreSum;
	}

	@Override
	public String toString() {
		return "GradeStandardScoreVo [examName=" + examName
				+ ", standardScoreSum=" + standardScoreSum + "]";
	}

}

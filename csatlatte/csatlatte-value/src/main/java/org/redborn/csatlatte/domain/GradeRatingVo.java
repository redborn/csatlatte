package org.redborn.csatlatte.domain;

public class GradeRatingVo {

	private String examName;
	private float ratingAverage;

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public float getRatingAverage() {
		return ratingAverage;
	}

	public void setRatingAverage(float ratingAverage) {
		this.ratingAverage = ratingAverage;
	}

	@Override
	public String toString() {
		return "GradeRatingVo [examName=" + examName + ", ratingAverage="
				+ ratingAverage + "]";
	}

}

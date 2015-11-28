package org.redborn.csatlatte.domain;

public class RatingCutVo {

	private int ratingCode;
	private int rawScore;
	private int standardScore;
	
	public int getRatingCode() {
		return ratingCode;
	}

	public void setRatingCode(int ratingCode) {
		this.ratingCode = ratingCode;
	}

	public int getRawScore() {
		return rawScore;
	}
	
	public void setRawScore(int rawScore) {
		this.rawScore = rawScore;
	}
	
	public int getStandardScore() {
		return standardScore;
	}
	
	public void setStandardScore(int standardScore) {
		this.standardScore = standardScore;
	}

	@Override
	public String toString() {
		return "RatingCutVo [ratingCode=" + ratingCode + ", rawScore="
				+ rawScore + ", standardScore=" + standardScore + "]";
	}

}

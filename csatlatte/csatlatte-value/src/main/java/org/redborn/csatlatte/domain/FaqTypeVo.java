package org.redborn.csatlatte.domain;

public class FaqTypeVo {

	private int typeSequence;
	private String description;

	public int getTypeSequence() {
		return typeSequence;
	}

	public void setTypeSequence(int typeSequence) {
		this.typeSequence = typeSequence;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TypeVo [typeSequence=" + typeSequence + ", description="
				+ description + "]";
	}

}

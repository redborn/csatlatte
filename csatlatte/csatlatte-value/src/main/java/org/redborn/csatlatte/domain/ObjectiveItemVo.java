package org.redborn.csatlatte.domain;

public class ObjectiveItemVo {

	private int objectiveItemSequence;
	private String content;

	public int getObjectiveItemSequence() {
		return objectiveItemSequence;
	}

	public void setObjectiveItemSequence(int objectiveItemSequence) {
		this.objectiveItemSequence = objectiveItemSequence;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ObjectiveItemVo [objectiveItemSequence=");
		builder.append(objectiveItemSequence);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}

}

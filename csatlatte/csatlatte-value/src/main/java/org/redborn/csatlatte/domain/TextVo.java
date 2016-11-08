package org.redborn.csatlatte.domain;

public class TextVo {

	private int textSequence;
	private int beginQuestionSequence;
	private int endQuestionSequence;
	private String content;
	private String description;
	
	public int getTextSequence() {
		return textSequence;
	}
	
	public void setTextSequence(int textSequence) {
		this.textSequence = textSequence;
	}
	
	public int getBeginQuestionSequence() {
		return beginQuestionSequence;
	}
	
	public void setBeginQuestionSequence(int beginQuestionSequence) {
		this.beginQuestionSequence = beginQuestionSequence;
	}
	
	public int getEndQuestionSequence() {
		return endQuestionSequence;
	}
	
	public void setEndQuestionSequence(int endQuestionSequence) {
		this.endQuestionSequence = endQuestionSequence;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TextVo [textSequence=" + textSequence
				+ ", beginQuestionSequence=" + beginQuestionSequence
				+ ", endQuestionSequence=" + endQuestionSequence + ", content="
				+ content + ", description=" + description + "]";
	}

}

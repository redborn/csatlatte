package org.redborn.csatlatte.domain;

import java.util.List;

public class QuestionVo {

	private int csatSequence;
	private int examSequence;
	private int sectionSequence;
	private int subjectSequence;
	private int questionSequence;
	private int questionTypeSequence;
	private int score;
	private String content;
	private List<ObjectiveItemVo> objectiveItemVos;

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

	public int getSubjectSequence() {
		return subjectSequence;
	}

	public void setSubjectSequence(int subjectSequence) {
		this.subjectSequence = subjectSequence;
	}

	public int getQuestionSequence() {
		return questionSequence;
	}

	public void setQuestionSequence(int questionSequence) {
		this.questionSequence = questionSequence;
	}

	public int getQuestionTypeSequence() {
		return questionTypeSequence;
	}

	public void setQuestionTypeSequence(int questionTypeSequence) {
		this.questionTypeSequence = questionTypeSequence;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<ObjectiveItemVo> getObjectiveItemVos() {
		return objectiveItemVos;
	}

	public void setObjectiveItemVos(List<ObjectiveItemVo> objectiveItemVos) {
		this.objectiveItemVos = objectiveItemVos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionVo [csatSequence=");
		builder.append(csatSequence);
		builder.append(", examSequence=");
		builder.append(examSequence);
		builder.append(", sectionSequence=");
		builder.append(sectionSequence);
		builder.append(", subjectSequence=");
		builder.append(subjectSequence);
		builder.append(", questionSequence=");
		builder.append(questionSequence);
		builder.append(", questionTypeSequence=");
		builder.append(questionTypeSequence);
		builder.append(", score=");
		builder.append(score);
		builder.append(", content=");
		builder.append(content);
		builder.append(", objectiveItemVos=");
		builder.append(objectiveItemVos);
		builder.append("]");
		return builder.toString();
	}

}

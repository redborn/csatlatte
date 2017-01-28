package org.redborn.csatlatte.persistence.question.text;

public interface ImageDao {

	public int selectOneCount(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence, int imageSequence);
	public String selectOneFileName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence, int imageSequence);
	public String selectOneFileCode(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence, int imageSequence);
	public int delete(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
}

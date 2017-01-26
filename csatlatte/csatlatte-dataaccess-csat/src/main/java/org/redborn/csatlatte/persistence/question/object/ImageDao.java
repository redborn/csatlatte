package org.redborn.csatlatte.persistence.question.object;

public interface ImageDao {

	public int selectOneCount(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int objectItemSequence, int imageSequence);
	public String selectOneFileName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int objectItemSequence, int imageSequence);
	public String selectOneFileCode(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int objectItemSequence, int imageSequence);
	public int delete(int csatSequence, int examSequence);
	public int delete(int csatSequence, int examSequence, int sectionSequence);
	public int delete(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
}

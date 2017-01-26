package org.redborn.csatlatte.persistence.exam.subject;

public interface ListeningDao {
	
	public int selectOneCount(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public String selectOneFileName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public String selectOneFileCode(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public int delete(int csatSequence, int examSequence);
	
}

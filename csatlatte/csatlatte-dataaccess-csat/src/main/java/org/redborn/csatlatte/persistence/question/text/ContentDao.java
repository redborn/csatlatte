package org.redborn.csatlatte.persistence.question.text;

import java.util.List;

public interface ContentDao {

	public List<String> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence);
	public int delete(int csatSequence, int examSequence);
	public int delete(int csatSequence, int examSequence, int sectionSequence);
	public int delete(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
}

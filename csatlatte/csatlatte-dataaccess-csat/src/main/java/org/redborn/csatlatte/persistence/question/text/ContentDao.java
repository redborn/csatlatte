package org.redborn.csatlatte.persistence.question.text;

import java.util.List;

public interface ContentDao {

	public List<String> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence);
	
}

package org.redborn.csatlatte.persistence.question;

import java.util.List;

import org.redborn.csatlatte.domain.TextVo;

public interface TextDao {

	public TextVo selectOne(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence);
	public List<TextVo> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
}

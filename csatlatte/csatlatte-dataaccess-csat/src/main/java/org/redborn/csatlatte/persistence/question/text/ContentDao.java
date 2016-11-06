package org.redborn.csatlatte.persistence.question.text;

import java.util.List;

import org.redborn.csatlatte.domain.TextVo;

public interface ContentDao {

	public List<TextVo> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence);
	
}

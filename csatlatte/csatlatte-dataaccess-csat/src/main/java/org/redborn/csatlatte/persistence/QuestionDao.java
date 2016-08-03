package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.QuestionVo;

public interface QuestionDao {

	public List<QuestionVo> selectList(int csatSequence, int examSequence);
	public int delete(int csatSequence, int examSequence);
	
}

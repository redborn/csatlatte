package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;

public interface RatingDao {

	public ExamVo selectOne(int csatSequence, int examSequence);
	public List<ExamVo> selectList(int csatSequence);
	
}

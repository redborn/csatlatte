package org.redborn.csatlatte.persistence.question.object;

import java.util.List;

import org.redborn.csatlatte.domain.CorrectAnswerVo;

public interface CorrectAnswerDao {

	public List<CorrectAnswerVo> selectList(CorrectAnswerVo correctAnswerVo);
	
}

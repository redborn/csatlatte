package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.QuestionVo;

public interface QuestionService {

	public List<QuestionVo> list(int csatSequence, int examSequence);
	public boolean delete(int csatSequence, int examSequence);
	
}

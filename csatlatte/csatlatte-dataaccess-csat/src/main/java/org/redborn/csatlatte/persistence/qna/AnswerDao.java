package org.redborn.csatlatte.persistence.qna;

import java.util.List;

import org.redborn.csatlatte.domain.QnaAnswerVo;

public interface AnswerDao {
	
	public int insert(QnaAnswerVo qnaAnswerVo);
	public List<String> selectList(int qnaSequence);
	
}

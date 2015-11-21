package org.redborn.csatlatte.persistence.qna;

import java.util.List;

import org.redborn.csatlatte.domain.QnaContentVo;

public interface ContentDao {
	
	public List<QnaContentVo> selectList(int qnaSequence);
	public int insert(QnaContentVo qnaContentVo);
	
}

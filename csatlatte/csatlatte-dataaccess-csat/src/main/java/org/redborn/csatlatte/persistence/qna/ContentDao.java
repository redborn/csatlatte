package org.redborn.csatlatte.persistence.qna;

import org.redborn.csatlatte.domain.QnaContentVo;

public interface ContentDao {
	
	public String selectList(int qnaSequence);
	public int insert(QnaContentVo qnaContentVo);
	
}

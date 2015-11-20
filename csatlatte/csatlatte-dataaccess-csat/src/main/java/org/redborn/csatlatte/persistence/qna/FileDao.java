package org.redborn.csatlatte.persistence.qna;

import java.util.List;

import org.redborn.csatlatte.domain.QnaFileVo;

public interface FileDao {

	public List<QnaFileVo> selectList(int qnaSequence);
	public int insert(QnaFileVo qnaFileVo);
	
}

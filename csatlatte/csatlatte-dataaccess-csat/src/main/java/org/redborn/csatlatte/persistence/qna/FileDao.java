package org.redborn.csatlatte.persistence.qna;

import java.util.List;

import org.redborn.csatlatte.domain.FileVo;

public interface FileDao {

	public List<FileVo> selectList(int qnaSequence);
	public int insert(int qnaSequence, FileVo fileVo);
	
}

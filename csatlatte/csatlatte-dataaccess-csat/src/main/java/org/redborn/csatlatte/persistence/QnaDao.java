package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaForStudentVo;
import org.redborn.csatlatte.domain.QnaVo;

public interface QnaDao {

	public QnaVo selectOne(int qnaSequence);
	public int selectOneMaxQnaSequence();
	public int selectOneCount(String search, int countQnaAnswer);
	public List<QnaForManageVo> selectListForManage(String search, int pageNumber, int countQnaAnswer);
	public List<QnaForStudentVo> selectListForStudent(int studentSequence);
	public int insert(int qnaSequence, int studentSequence, String title, String userAgent, String sessionId, String ip);
	public int updateUseYnN(int qnaSequence);
	
}

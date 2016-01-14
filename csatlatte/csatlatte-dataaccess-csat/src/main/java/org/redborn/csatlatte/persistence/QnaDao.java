package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaForStudentVo;
import org.redborn.csatlatte.domain.QnaVo;

public interface QnaDao {

	public QnaVo selectOne(int qnaSequence);
	public int selectOneMaxQnaSequence();
	public int selectOneCount(String search, String useYn);
	public List<QnaForManageVo> selectListForManage(String search, int pageNumber, String useYn);
	public List<QnaForStudentVo> selectListForStudent(int studentSequence, int pageNumber);
	public int insert(int qnaSequence, int studentSequence, String title);
	public int updateUseYnN(int qnaSequence);
	
}

package org.redborn.csatlatte.persistence;

import java.sql.Date;
import java.util.List;

import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaForStudentVo;
import org.redborn.csatlatte.domain.QnaVo;

public interface QnaDao {

	public QnaVo selectOne(int qnaSequence);
	public int selectOneMaxQnaSequence();
	public List<QnaForManageVo> selectListForManage(String search, int begin);
	public List<QnaForStudentVo> selectListForStudent(int studentSequence, int begin);
	public int insert(int qnaSequence, int studentSequence);
	public int updateUseYnN(int qnaSequence);
	
}

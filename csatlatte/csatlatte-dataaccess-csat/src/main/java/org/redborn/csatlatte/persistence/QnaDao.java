package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.QnaVo;

public interface QnaDao {

	public List<QnaVo> selectList(int qnaSequence);
	public int selectOneMaxQnaSequence();
	public List<QnaVo> selectListForManage(String search, int begin);
	public List<QnaVo> selectListForStudent(int studentSequence, String search, int begin);
	public int insert(int qnaSequence, int studentSequence);
	public int updateUseYnN(int qnaSequence);
	
}

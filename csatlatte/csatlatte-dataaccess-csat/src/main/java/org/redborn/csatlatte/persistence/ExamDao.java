package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;

public interface ExamDao {
	
	public int selectOne();
	public List<ExamVo> selectListExam(int csatSequence);
	public List<ExamVo> selectListExamForManage(int pageNumber, String search);
	public int insert(ExamVo examVo);
	public int update(ExamVo examVo);
	public int delete(int examSequence);
}

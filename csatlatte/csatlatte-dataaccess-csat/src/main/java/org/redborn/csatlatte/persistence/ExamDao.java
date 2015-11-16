package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;

public interface ExamDao {
	
	public List<ExamVo> selectListExam(int csatSequence);
	public int insert(ExamVo examVo);
	public int update(ExamVo examVo);
	public int delete(int examSequence);
}

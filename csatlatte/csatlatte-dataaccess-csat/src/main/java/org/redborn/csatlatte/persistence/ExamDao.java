package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;

public interface ExamDao {
	
	public List<ExamVo> list(int csatSequence);
	public int register(ExamVo examVo);
	public int modify(ExamVo examVo);
	public int delete(int examSequence);
}

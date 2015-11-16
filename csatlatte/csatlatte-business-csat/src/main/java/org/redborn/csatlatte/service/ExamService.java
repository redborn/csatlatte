package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.persistence.CsatDao;

public interface ExamService {

	public List<CsatDao> selectListYear();
	public List<ExamVo> selectListExam(int csatSequence);
	public int insert(ExamVo examVo);
	public int update(ExamVo examVo);
	public int delete(int examSequence);
	
}

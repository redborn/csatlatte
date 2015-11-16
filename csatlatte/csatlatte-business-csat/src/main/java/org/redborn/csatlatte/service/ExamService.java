package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.persistence.CsatDao;

public interface ExamService {

	public List<CsatDao> yearList();
	public List<ExamVo> list(int csatSequence);
	public int register(ExamVo examVo);
	public int modify(ExamVo examVo);
	public int delete(int examSequence);
	
}

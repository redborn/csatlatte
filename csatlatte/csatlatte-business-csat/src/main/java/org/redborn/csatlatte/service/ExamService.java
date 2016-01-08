package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.IstttVo;

public interface ExamService {

	public List<CsatVo> yearList();
	public List<ExamVo> list(int csatSequence);
	public List<ExamVo> listForManage(int pageNumber, String search);
	public int register(ExamVo examVo);
	public int modify(ExamVo examVo);
	public int delete(int examSequence);
	public int amountExam(String search);
	public List<IstttVo> istttList();
	public List<ExamVo> listForManageOne(int examSequence);
	
}

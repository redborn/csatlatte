package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.persistence.CsatDao;
import org.redborn.csatlatte.persistence.ExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao examDao;
	
	@Autowired
	private CsatDao csatDao;
	
	public List<CsatVo> yearList() {
		return csatDao.selectListYear();
	}
	
	public List<ExamVo> list(int csatSequence) {
		return examDao.selectListExam(csatSequence);
	}
	
	public List<ExamVo> listForManage(int pageNumber, String search) {
		return examDao.selectListExamForManage(pageNumber, search);
	}

	public int register(ExamVo examVo) {
		return examDao.insert(examVo);
	}

	public int modify(ExamVo examVo) {
		return examDao.update(examVo);
	}

	public int delete(int examSequence) {
		return examDao.delete(examSequence);
	}
	
	public int amountExam(String search) {
		return examDao.selectOne(search);
	}

}

package org.redborn.csatlatte.service;

import java.util.List;

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
	
	public List<CsatDao> selectListYear() {
		return csatDao.selectListYear();
	}
	
	public List<ExamVo> selectListExam(int csatSequence) {
		return examDao.selectListExam(csatSequence);
	}

	public int insert(ExamVo examVo) {
		return examDao.insert(examVo);
	}

	public int update(ExamVo examVo) {
		return examDao.update(examVo);
	}

	public int delete(int examSequence) {
		return examDao.delete(examSequence);
	}

}

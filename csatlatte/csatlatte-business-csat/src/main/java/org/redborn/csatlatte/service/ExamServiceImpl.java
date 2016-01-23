package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.InstitutionVo;
import org.redborn.csatlatte.persistence.CsatDao;
import org.redborn.csatlatte.persistence.ExamDao;
import org.redborn.csatlatte.persistence.InstitutionDao;
import org.redborn.csatlatte.persistence.RatingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao examDao;
	@Autowired
	private CsatDao csatDao;
	@Autowired
	private InstitutionDao institutionDao;
	@Autowired
	private RatingDao ratingDao;
	
	public boolean checkForDelete(int csatSequence, int examSequence) {
		return examDao.selectOneCountForDelete(csatSequence, examSequence) == 1;
	}
	
	public List<CsatVo> yearList() {
		return csatDao.selectListYear();
	}
	
	public List<ExamVo> list(int csatSequence) {
		return examDao.selectListExam(csatSequence);
	}
	
	public List<ExamVo> listForManage(int csatSequence) {
		return examDao.selectListExamForManage(csatSequence);
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
	
	public int amountExam(int csatSequence, String search) {
		return examDao.selectOneCount(csatSequence, search);
	}
	
	public List<InstitutionVo> institutionList() {
		return institutionDao.selectList();
	}
	
	public List<ExamVo> listForManageOne(int examSequence) {
		return examDao.selectListExamOneForManage(examSequence);
	}
	
	public List<ExamVo> listForRatingManage(int csatSequence) {
		return ratingDao.selectList(csatSequence);
	}

}

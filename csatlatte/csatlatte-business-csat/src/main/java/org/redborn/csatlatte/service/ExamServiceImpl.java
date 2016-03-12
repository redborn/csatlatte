package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamDDayVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.GradeVo;
import org.redborn.csatlatte.domain.InstitutionVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.redborn.csatlatte.persistence.CsatDao;
import org.redborn.csatlatte.persistence.ExamDao;
import org.redborn.csatlatte.persistence.InstitutionDao;
import org.redborn.csatlatte.persistence.exam.AverageDao;
import org.redborn.csatlatte.persistence.exam.RatingCutDao;
import org.redborn.csatlatte.persistence.exam.SectionDao;
import org.redborn.csatlatte.persistence.exam.SubjectDao;
import org.redborn.csatlatte.persistence.exam.student.ScoreDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExamDao examDao;
	@Autowired
	private CsatDao csatDao;
	@Autowired
	private InstitutionDao institutionDao;
	@Autowired
	private RatingCutDao ratingCutDao;
	@Autowired
	private AverageDao averageDao;
	@Autowired
	private SectionDao sectionDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private ScoreDao scoreDao;

	public CsatVo getCsat(int csatSequence) {
		logger.info("Business layer exam getCsat.");
		return csatDao.selectOne(csatSequence);
	}
	
	public List<CsatVo> csatList() {
		logger.info("Business layer exam csatList.");
		return csatDao.selectListYear();
	}
	
	public List<String> yearList(int yearStudentSequence) {
		logger.info("Business layer exam yearList.");
		return examDao.selectListYear(yearStudentSequence);
	}
	
	public List<ExamVo> list(String year, int yearStudentSequence) {
		logger.info("Business layer exam list.");
		return examDao.selectListExam(year, yearStudentSequence);
	}
	
	public List<ExamVo> listForManage(int csatSequence) {
		logger.info("Business layer exam listForManage");
		return examDao.selectListExamForManage(csatSequence);
	}
	
	public List<AverageVo> averageList(int csatSequence, int examSequence) {
		logger.info("Business layer exam averageList");
		return averageDao.selectList(csatSequence, examSequence);
	}
	
	public List<SectionVo> sectionList(int csatSequence, int examSequence) {
		logger.info("Business layer exam sectionList.");
		return sectionDao.selectList(csatSequence, examSequence);
	}
	
	public List<SubjectVo> subjectList(int csatSequence, int examSequence) {
		logger.info("Business layer exam subjectList.");
		return subjectDao.selectList(csatSequence, examSequence);
	}

	public boolean register(ExamVo examVo) {
		logger.info("Business layer exam register.");
		examVo.setExamSequence(examDao.selectOneCountMax(examVo.getCsatSequence()));
		return examDao.insert(examVo) == 1;
	}

	public boolean modify(ExamVo examVo) {
		logger.info("Business layer exam modify.");
		return examDao.update(examVo) == 1;
	}

	public boolean delete(int csatSequence, int examSequence) {
		logger.info("Business layer exam delete.");
		return examDao.delete(csatSequence, examSequence) == 1;
	}
	
	public List<InstitutionVo> institutionList() {
		logger.info("Business layer exam institutionList.");
		return institutionDao.selectList();
	}
	
	public List<ExamVo> detail(int csatSequence, int examSequence) {
		logger.info("Business layer exam detail.");
		return examDao.selectListDetailForManage(csatSequence, examSequence);
	}
	
	public List<ExamVo> listForRatingManage(int csatSequence) {
		logger.info("Business layer exam listForRatingManage.");
		return ratingCutDao.selectList(csatSequence);
	}
	
	public List<ExamVo> listForRatingCreate(int csatSequence) {
		logger.info("Business layer exam listForRatingCreate.");
		return ratingCutDao.selectListForCreate(csatSequence);
	}
	
	public List<GradeVo> examStudentList(int csatSequence, int examSequence) {
		logger.info("Business layer exam examStudentList.");
		return scoreDao.selectListExamStudent(csatSequence, examSequence);
	}
	
	public ExamDDayVo examDday(int csatSequence) {
		logger.info("Business Layer exam examDday.");
		return examDao.selectOneDDay(csatSequence);
	}
}

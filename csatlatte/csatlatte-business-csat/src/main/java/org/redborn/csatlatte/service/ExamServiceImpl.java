package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.CsatVo;
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
	private RatingCutDao ratingCutDao;
	@Autowired
	private AverageDao averageDao;
	@Autowired
	private SectionDao sectionDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private ScoreDao scoreDao;
	
	public List<CsatVo> csatList() {
		return csatDao.selectListYear();
	}
	
	public List<ExamVo> list(int csatSequence, int yearStudentSequence) {
		return examDao.selectListExam(csatSequence, yearStudentSequence);
	}
	
	public List<ExamVo> listForManage(int csatSequence) {
		return examDao.selectListExamForManage(csatSequence);
	}
	
	public List<AverageVo> averageList(int csatSequence, int examSequence) {
		return averageDao.selectList(csatSequence, examSequence);
	}
	
	public List<SectionVo> sectionList(int csatSequence, int examSequence) {
		return sectionDao.selectList(csatSequence, examSequence);
	}
	
	public List<SubjectVo> subjectList(int csatSequence, int examSequence) {
		return subjectDao.selectList(csatSequence, examSequence);
	}

	public int register(ExamVo examVo) {
		return examDao.insert(examVo);
	}

	public int modify(ExamVo examVo) {
		return examDao.update(examVo);
	}

	public int delete(int csatSequence, int examSequence) {
		return examDao.delete(csatSequence, examSequence);
	}
	
	public int amountExam(int csatSequence, String search) {
		return examDao.selectOneCount(csatSequence, search);
	}
	
	public List<InstitutionVo> institutionList() {
		return institutionDao.selectList();
	}
	
	public List<ExamVo> detail(int csatSequence, int examSequence) {
		return examDao.selectListExamOneForManage(csatSequence, examSequence);
	}
	
	public List<ExamVo> listForRatingManage(int csatSequence) {
		return ratingCutDao.selectList(csatSequence);
	}
	
	public List<ExamVo> listForRatingCreate(int csatSequence) {
		return ratingCutDao.selectListForCreate(csatSequence);
	}
	
	public List<GradeVo> examStudentList(int csatSequence, int examSequence) {
		return scoreDao.selectListExamStudent(csatSequence, examSequence);
	}

}

package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.redborn.csatlatte.persistence.exam.AverageDao;
import org.redborn.csatlatte.persistence.exam.RatingCutDao;
import org.redborn.csatlatte.persistence.exam.SectionDao;
import org.redborn.csatlatte.persistence.exam.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingCutServiceImpl implements RatingCutService {

	@Autowired
	private AverageDao averageDao;
	@Autowired
	private RatingCutDao ratingCutDao;
	@Autowired
	private SectionDao sectionDao;
	@Autowired
	private SubjectDao subjectDao;
	
	public List<RatingCutVo> list(int csatSequence, int examSequence) {
		return ratingCutDao.selectListDetail(csatSequence, examSequence);
	}
	
	public List<ExamVo> listForRatingManage(int csatSequence) {
		return ratingCutDao.selectList(csatSequence);
	}
	
	public List<ExamVo> listForRatingCreate(int csatSequence) {
		return ratingCutDao.selectListForCreate(csatSequence);
	}
	
	public boolean deleteAverage(int csatSequence, int examSequence) {
		return ratingCutDao.deleteAverage(csatSequence, examSequence) > 0;
	}
	
	public boolean deleteSection(int csatSequence, int examSequence) {
		return ratingCutDao.deleteSection(csatSequence, examSequence) > 0;
	}
	
	public boolean deleteSubject(int csatSequence, int examSequence) {
		return ratingCutDao.deleteSubject(csatSequence, examSequence) > 0;
	}
	
	public boolean deleteRatingCut(int csatSequence, int examSequence) {
		return ratingCutDao.deleteRatingCut(csatSequence, examSequence) > 0;
	}
	
	public boolean deleteStudentScore(int csatSequence, int examSequence) {
		return ratingCutDao.deleteStudentScore(csatSequence, examSequence) > 0;
	}

	public boolean register(SectionVo sectionVo, SubjectVo subjectVo, RatingCutVo ratingCutVo, AverageVo averageVo) {
		return sectionDao.insert(sectionVo) == 1 && subjectDao.insert(subjectVo) == 1 && 
				ratingCutDao.insert(ratingCutVo) == 1 && averageDao.insert(averageVo) == 1;
	}

}
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

	public boolean register(int csatSequence, int examSequence, List<SectionVo> sectionList, List<SubjectVo> subjectList, List<RatingCutVo> ratingCutList, List<AverageVo> averageList) {
		boolean result = false;
		boolean sectionSuccess = false;
		boolean subjectSuccess = false;
		boolean ratingCutSuccess = false;
		
		if (sectionList != null) {
			int sectionListSize = sectionList.size();
			for (int index = 0; index < sectionListSize; index++) {
				SectionVo sectionVo = sectionList.get(index);
				sectionVo.setCsatSequence(csatSequence);
				sectionVo.setExamSequence(examSequence);
				sectionDao.insert(sectionVo);
			}
			sectionSuccess = true;
		}
			
		if (subjectList != null && sectionSuccess) {
			int subjectListSize = subjectList.size();
			for (int index = 0; index < subjectListSize; index++) {
				SubjectVo subjectVo = subjectList.get(index);
				subjectVo.setCsatSequence(csatSequence);
				subjectVo.setExamSequence(examSequence);
				subjectDao.insert(subjectVo);
			}
			subjectSuccess = true;
		}
			
		if (ratingCutList != null && sectionSuccess && subjectSuccess) {
			int ratingCutListSize = ratingCutList.size();
			for (int index = 0; index < ratingCutListSize; index++) {
				RatingCutVo ratingCutVo = ratingCutList.get(index);
				ratingCutVo.setCsatSequence(csatSequence);
				ratingCutVo.setExamSequence(examSequence);
				ratingCutDao.insert(ratingCutVo);
			}
			ratingCutSuccess = true;
		}
		
		if (averageList != null && sectionSuccess && subjectSuccess && ratingCutSuccess) {
			int averageListSize = averageList.size();
			for (int index = 0; index < averageListSize; index++) {
				AverageVo averageVo = averageList.get(index);
				averageVo.setCsatSequence(csatSequence);
				averageVo.setExamSequence(examSequence);
				averageDao.insert(averageVo);
			}
			result = true;
		}
		
		return result;
	}

}
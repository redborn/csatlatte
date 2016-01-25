package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.RatingCutScoreVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.redborn.csatlatte.persistence.exam.AverageDao;
import org.redborn.csatlatte.persistence.exam.RatingCutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingCutServiceImpl implements RatingCutService {

	@Autowired
	private AverageDao averageDao;
	@Autowired
	private RatingCutDao ratingCutDao;
	
	public List<RatingCutVo> list(int csatSequence, int examSequence, 
			int upperRatingCode, int lowerRatingCode) {
		return ratingCutDao.selectListDetail(csatSequence, examSequence, upperRatingCode, lowerRatingCode);
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

	public boolean register(SubjectVo subjectVo, int average, int standardDeviation, List<RatingCutScoreVo> ratingCutScoreVo) {
		int max = ratingCutScoreVo.size();
		boolean result = true;
		
		for (int index = 0; index < max; index++) {
			if(ratingCutDao.insert(subjectVo, ratingCutScoreVo.get(index)) != 1) {
				result = false;
				break;
			}
		}
		
		if (result != true || averageDao.insert(subjectVo, average, standardDeviation) != 1) {
			result = false;
		}
		
		return result;
	}

}
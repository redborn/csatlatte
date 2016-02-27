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
import org.redborn.csatlatte.persistence.exam.student.ScoreDao;
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
	@Autowired
	private ScoreDao scoreDao;
	
	public List<RatingCutVo> list(int csatSequence, int examSequence) {
		return ratingCutDao.selectListDetail(csatSequence, examSequence);
	}
	
	public List<ExamVo> listForRatingManage(int csatSequence) {
		return ratingCutDao.selectList(csatSequence);
	}
	
	public List<ExamVo> listForRatingCreate(int csatSequence) {
		return ratingCutDao.selectListForCreate(csatSequence);
	}
	
	public boolean delete(int csatSequence, int examSequence) {
		boolean result = false;
		if (scoreDao.deleteForManage(csatSequence, examSequence) > 0 && ratingCutDao.delete(csatSequence, examSequence) > 0
				&& averageDao.delete(csatSequence, examSequence) > 0 && subjectDao.delete(csatSequence, examSequence) > 0
				&& sectionDao.delete(csatSequence, examSequence) > 0) {
			result = true;
		}
		return result;
	}

	public boolean register(List<SectionVo> sectionList, List<SubjectVo> subjectList, List<RatingCutVo> ratingCutList, List<AverageVo> averageList) {
		boolean result = false;
		boolean sectionSuccess = false;
		boolean subjectSuccess = false;
		boolean ratingCutSuccess = false;
		
		if (sectionList != null) {
			int sectionListSize = sectionList.size();
			for (int index = 0; index < sectionListSize; index++) {
				sectionDao.insert(sectionList.get(index));
			}
			sectionSuccess = true;
		}
			
		if (subjectList != null && sectionSuccess) {
			int subjectListSize = subjectList.size();
			for (int index = 0; index < subjectListSize; index++) {
				subjectDao.insert(subjectList.get(index));
			}
			subjectSuccess = true;
		}
			
		if (ratingCutList != null && sectionSuccess && subjectSuccess) {
			int ratingCutListSize = ratingCutList.size();
			for (int index = 0; index < ratingCutListSize; index++) {
				ratingCutDao.insert(ratingCutList.get(index));
			}
			ratingCutSuccess = true;
		}
		
		if (averageList != null && sectionSuccess && subjectSuccess && ratingCutSuccess) {
			int averageListSize = averageList.size();
			for (int index = 0; index < averageListSize; index++) {
				averageDao.insert(averageList.get(index));
			}
			result = true;
		}
		
		return result;
	}

}
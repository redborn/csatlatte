package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.RatingCutScoreVo;
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
	
	public List<RatingCutScoreVo> list(int csatSequence, int examSequence) {
		return ratingCutDao.selectList(csatSequence, examSequence);
	}

	public boolean register(SubjectVo subjectVo, int average, int standardDeviation, List<RatingCutScoreVo> ratingCutScoreVo) {
		int max = ratingCutScoreVo.size();
		boolean result = false;
		
		for (int index = 0; index < max; index++) {
			if(ratingCutDao.insert(subjectVo, ratingCutScoreVo.get(index)) == 1) {
				result = true;
			} else {
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
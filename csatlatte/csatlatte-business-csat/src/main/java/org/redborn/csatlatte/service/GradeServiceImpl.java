package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.GradeListVo;
import org.redborn.csatlatte.domain.GradeRatingVo;
import org.redborn.csatlatte.domain.GradeStandardScoreVo;
import org.redborn.csatlatte.domain.GradeVo;
import org.redborn.csatlatte.persistence.exam.student.ScoreDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ScoreDao scoreDao;
	
	public boolean register(GradeVo gradeVo) {
		logger.info("Business layer grade register.");
		return scoreDao.insert(gradeVo) == 1;
	}

	public boolean modify(GradeVo gradeVo) {
		logger.info("Business layer grade modify.");
		return scoreDao.update(gradeVo) == 1;
	}

	public boolean delete(int studentSequence, int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		logger.info("Business layer grade delete.");
		return scoreDao.delete(studentSequence, csatSequence, examSequence, sectionSequence, subjectSequence) == 1;
	}

	public List<GradeListVo> list(int csatSequence, int examSequence, int studentSequence) {
		logger.info("Business layer grade list.");
		return scoreDao.selectList(csatSequence, examSequence, studentSequence);
	}

	public List<GradeRatingVo> ratingCutList(int csatSequence, int studentSequence) {
		logger.info("Business layer grade ratingCutList.");
		return scoreDao.selectListRating(csatSequence, studentSequence);
	}

	public List<GradeStandardScoreVo> standardScoreList(int csatSequence, int studentSequence) {
		logger.info("Business layer grade standardScoreList.");
		return scoreDao.selectListStandardScore(csatSequence, studentSequence);
	}

}

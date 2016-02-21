package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.GradeListVo;
import org.redborn.csatlatte.domain.GradeRatingVo;
import org.redborn.csatlatte.domain.GradeStandardscoreVo;
import org.redborn.csatlatte.domain.GradeVo;
import org.redborn.csatlatte.persistence.exam.student.ScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private ScoreDao scoreDao;
	
	public boolean register(GradeVo gradeVo) {
		return scoreDao.insert(gradeVo) == 1;
	}

	public boolean modify(GradeVo gradeVo) {
		return scoreDao.update(gradeVo) == 1;
	}

	public boolean delete(int studentSequence, int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		return scoreDao.delete(studentSequence, csatSequence, examSequence, sectionSequence, subjectSequence) == 1;
	}

	public List<GradeListVo> list(int csatSequence, int examSequence, int studentSequence) {
		return scoreDao.selectList(csatSequence, examSequence, studentSequence);
	}

	public List<GradeRatingVo> ratingcutHistory(int csatSequence, int examSequence, int studentSequence) {
		return scoreDao.selectListRating(csatSequence, examSequence, studentSequence);
	}

	public List<GradeStandardscoreVo> standardscoreHistory(int csatSequence, int examSequence, int studentSequence) {
		return scoreDao.selectListStandardscore(csatSequence, examSequence, studentSequence);
	}

}

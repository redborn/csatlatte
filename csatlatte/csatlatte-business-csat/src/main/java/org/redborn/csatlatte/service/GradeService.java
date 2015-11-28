package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.GradeRatingVo;
import org.redborn.csatlatte.domain.GradeStandardscoreVo;
import org.redborn.csatlatte.domain.GradeVo;

public interface GradeService {
	
	public boolean register(GradeVo gradeVo);
	public boolean modify(GradeVo gradeVo);
	public boolean delete(int studentSequence, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public List<GradeVo> list(int csatSequence, int examSequence, int studentSequence);
	public List<GradeRatingVo> ratingcutHistory(int csatSequence, int examSequence, int studentSequence);
	public List<GradeStandardscoreVo> standardscoreHistory(int csatSequence, int examSequence, int studentSequence);
	
}

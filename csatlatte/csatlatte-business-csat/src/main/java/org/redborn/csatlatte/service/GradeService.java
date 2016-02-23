package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.GradeListVo;
import org.redborn.csatlatte.domain.GradeRatingVo;
import org.redborn.csatlatte.domain.GradeStandardScoreVo;
import org.redborn.csatlatte.domain.GradeVo;

public interface GradeService {
	
	public boolean register(GradeVo gradeVo);
	public boolean modify(GradeVo gradeVo);
	public boolean delete(int studentSequence, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public List<GradeListVo> list(int csatSequence, int examSequence, int studentSequence);
	public List<GradeRatingVo> ratingCutList(int csatSequence, int studentSequence);
	public List<GradeStandardScoreVo> standardScoreList(int csatSequence, int studentSequence);
	
}

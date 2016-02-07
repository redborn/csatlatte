package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

public interface RatingCutService {

	public List<RatingCutVo> list(int csatSequence, int examSequence);
	public boolean deleteAverage(int csatSequence, int examSequence);
	public boolean deleteSection(int csatSequence, int examSequence);
	public boolean deleteSubject(int csatSequence, int examSequence);
	public boolean deleteRatingCut(int csatSequence, int examSequence);
	public boolean deleteStudentScore(int csatSequence, int examSequence);
	public boolean register(SectionVo sectionVo, SubjectVo subjectVo, RatingCutVo ratingCutVo, AverageVo averageVo);
	
}

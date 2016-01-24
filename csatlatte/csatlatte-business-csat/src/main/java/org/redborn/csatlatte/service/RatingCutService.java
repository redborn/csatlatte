package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.RatingCutScoreVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SubjectVo;

public interface RatingCutService {

	public List<RatingCutScoreVo> list(int csatSequence, int examSequence);
	public List<RatingCutVo> list(int csatSequence, int examSequence, int upperRatingCode, int lowerRatingCode);
	public boolean register(SubjectVo subjectVo, int average, int standardDeviation, List<RatingCutScoreVo> ratingCutScoreVo);
	
}

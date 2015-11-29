package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.RatingCutScoreVo;
import org.redborn.csatlatte.domain.SubjectVo;

public interface RatingCutDao {
	
	public List<RatingCutScoreVo> selectList(int csatSequence, int examSequence);
	public int insert(SubjectVo subjectVo, RatingCutScoreVo ratingCutScoreVo);
	
}

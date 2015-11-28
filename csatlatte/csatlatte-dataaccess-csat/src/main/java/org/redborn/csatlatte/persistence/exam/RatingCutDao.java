package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.RatingCutVo;

public interface RatingCutDao {
	
	public List<RatingCutVo> list(int csatSequence, int examSequence);
	public int insert(RatingCutVo ratingCutVo);
	
}

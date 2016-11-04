package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.RatingCutVo;

public interface RatingCutDao {
	
	public List<ExamVo> selectList(int csatSequence);
	public List<RatingCutVo> selectListDetail(int csatSequence, int examSequence);
	public List<RatingCutVo> selectListDetailForSolving(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public List<ExamVo> selectListForCreate(int csatSequence);
	public int delete(int csatSequence, int examSequence);
	public int insert(RatingCutVo ratingCutVo);
	
}

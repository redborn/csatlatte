package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.RatingCutVo;

public interface RatingCutDao {
	
	public int selectOneCount(RatingCutVo ratingCutVo);
	public int selectOneRatingByScore(int score, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public List<ExamVo> selectList(int csatSequence);
	public List<RatingCutVo> selectListDetail(int csatSequence, int examSequence);
	public List<ExamVo> selectListForCreate(int csatSequence);
	public List<RatingCutVo> selectListForModifyRatingCut(List<RatingCutVo> ratingCutList);
	public int delete(int csatSequence, int examSequence);
	public int insert(RatingCutVo ratingCutVo);
	public int update(RatingCutVo ratingCutVo);
	public int delete(int csatSequence, int examSequence, int sectionSequence);
	public int delete(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
}

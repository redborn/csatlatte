package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

public interface RatingCutDao {
	
	public int selectOneCount(RatingCutVo ratingCutVo);
	public int selectOneRatingByScore(int score, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public List<ExamVo> selectList(int csatSequence);
	public List<RatingCutVo> selectListDetail(int csatSequence, int examSequence);
	public List<ExamVo> selectListForCreate(int csatSequence);
	public int insert(RatingCutVo ratingCutVo);
	public int update(RatingCutVo ratingCutVo);
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence);
	public int deleteForModifyRatingCut(List<RatingCutVo> ratingCutList);
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList);
	public int deleteForModifyRatingCutBySection(List<SectionVo> sectionList);
	
}

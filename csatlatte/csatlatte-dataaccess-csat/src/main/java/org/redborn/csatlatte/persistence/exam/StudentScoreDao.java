package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.GradeRatingVo;
import org.redborn.csatlatte.domain.GradeStandardscoreVo;
import org.redborn.csatlatte.domain.GradeVo;

public interface StudentScoreDao {

	public int insert(GradeVo gradeVo);
	public int update(GradeVo gradeVo);
	public int delete(int StudentSequence, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public List<GradeVo> selectList(int csatSequence, int examSequence, int studentSequence);
	public List<GradeRatingVo> selectListRating(int csatSequence, int examSequence, int studentSequence);
	public List<GradeStandardscoreVo> selectListStandardscore(int csatSequence, int examSequence, int studentSequence);
	
}

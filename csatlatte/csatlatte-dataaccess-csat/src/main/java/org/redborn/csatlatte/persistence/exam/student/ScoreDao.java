package org.redborn.csatlatte.persistence.exam.student;

import java.util.List;

import org.redborn.csatlatte.domain.GradeListVo;
import org.redborn.csatlatte.domain.GradeRatingVo;
import org.redborn.csatlatte.domain.GradeStandardScoreVo;
import org.redborn.csatlatte.domain.GradeVo;

public interface ScoreDao {

	public int insert(GradeVo gradeVo);
	public int update(GradeVo gradeVo);
	public int delete(int studentSequence, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public List<GradeListVo> selectList(int csatSequence, int examSequence, int studentSequence);
	public List<GradeVo> selectListExamStudent(int csatSequence, int examSequence);
	public List<GradeRatingVo> selectListRating(int csatSequence, int studentSequence);
	public List<GradeStandardScoreVo> selectListStandardScore(int csatSequence, int studentSequence);
	
}

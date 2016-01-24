package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;

public interface RatingDao {

	public int selectOne(int csatSequence, int examSequence);
	public List<ExamVo> selectList(int csatSequence);
	public int deleteAverage(int csatSequence, int examSequence);
	public int deleteSection(int csatSequence, int examSequence);
	public int deleteSubject(int csatSequence, int examSequence);
	public int deleteRatingCut(int csatSequence, int examSequence);
	public int deleteStudentScore(int csatSequence, int examSequence);
	
}

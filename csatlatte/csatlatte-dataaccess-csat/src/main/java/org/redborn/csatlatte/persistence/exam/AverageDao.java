package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;

public interface AverageDao {

	public int selectOneCount(AverageVo averageVo);
	public int selectOneStandardScore(int score, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public List<AverageVo> selectList(int csatSequence, int examSequence);
	public List<AverageVo> selectListForModifyRatingCut(List<AverageVo> averageList);
	public int insert(AverageVo averageVo);
	public int update(AverageVo averageVo);
	public int delete(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
}

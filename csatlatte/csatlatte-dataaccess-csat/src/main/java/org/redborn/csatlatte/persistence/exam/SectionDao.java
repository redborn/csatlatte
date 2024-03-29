package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.SectionVo;

public interface SectionDao {
	
	public int selectOneCount(SectionVo sectionVo);
	public List<SectionVo> selectList(int csatSequence, int examSequence);
	public int insert(SectionVo sectionVo);
	public int update(SectionVo sectionVo);
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence);
	public int deleteForModifyRatingCut(List<SectionVo> sectionList);
	
}

package org.redborn.csatlatte.persistence.question;

import java.util.List;

import org.redborn.csatlatte.domain.ObjectiveItemVo;
import org.redborn.csatlatte.domain.QuestionVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

public interface ObjectiveItemDao {
	
	public List<ObjectiveItemVo> selectList(QuestionVo questionVo);
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence);
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList);
	public int deleteForModifyRatingCutBySection(List<SectionVo> sectionList);
	
}

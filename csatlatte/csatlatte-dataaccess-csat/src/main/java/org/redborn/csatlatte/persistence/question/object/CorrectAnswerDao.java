package org.redborn.csatlatte.persistence.question.object;

import java.util.List;

import org.redborn.csatlatte.domain.CorrectAnswerVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

public interface CorrectAnswerDao {

	public CorrectAnswerVo selectOne(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence);
	public List<CorrectAnswerVo> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence);
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList);
	public int deleteForModifyRatingCutBySection(List<SectionVo> sectionList);
	
}

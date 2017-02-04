package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.QuestionVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

public interface QuestionDao {
	
	public QuestionVo selectOne(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence);
	public List<QuestionVo> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public QuestionVo selectOneForRandomsolving(List<Integer> yearStudentSequence, List<Integer> subjectSequence);
	public int selectOneCount(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence);
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence);
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList);
	public int deleteForModifyRatingCutBySection(List<SectionVo> sectionList);

}

package org.redborn.csatlatte.persistence.question.text;

import java.util.List;

import org.redborn.csatlatte.domain.SubjectVo;

public interface ContentDao {

	public List<String> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence);
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence);
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList);
	
}

package org.redborn.csatlatte.persistence.question;

import java.util.List;

import org.redborn.csatlatte.domain.SubjectVo;
import org.redborn.csatlatte.domain.TextVo;

public interface TextDao {

	public TextVo selectOne(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence);
	public List<TextVo> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence);
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList);
	
}

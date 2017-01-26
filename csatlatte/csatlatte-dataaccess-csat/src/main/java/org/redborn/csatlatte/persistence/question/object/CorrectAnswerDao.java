package org.redborn.csatlatte.persistence.question.object;

import java.util.List;

import org.redborn.csatlatte.domain.CorrectAnswerVo;

public interface CorrectAnswerDao {

	public CorrectAnswerVo selectOne(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence);
	public List<CorrectAnswerVo> selectList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public int delete(int csatSequence, int examSequence);
	public int delete(int csatSequence, int examSequence, int sectionSequence);
	public int delete(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
}

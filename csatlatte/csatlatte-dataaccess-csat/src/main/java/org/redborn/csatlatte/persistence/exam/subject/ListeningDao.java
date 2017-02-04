package org.redborn.csatlatte.persistence.exam.subject;

import java.util.List;

import org.redborn.csatlatte.domain.SubjectVo;

public interface ListeningDao {
	
	public int selectOneCount(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public String selectOneFileName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public String selectOneFileCode(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public int delete(int csatSequence, int examSequence);
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList);
	
}

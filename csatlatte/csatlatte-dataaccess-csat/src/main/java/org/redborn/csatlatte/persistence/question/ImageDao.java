package org.redborn.csatlatte.persistence.question;

import java.util.List;

import org.redborn.csatlatte.domain.SubjectVo;

public interface ImageDao {

	public int selectOneCount(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int imageSequence);
	public String selectOneFileName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int imageSequence);
	public String selectOneFileCode(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int imageSequence);
	public int delete(int csatSequence, int examSequence, Integer sectionSequence, Integer subjectSequence);
	public int deleteForModifyRatingCutBySubject(List<SubjectVo> subjectList);
	
}

package org.redborn.csatlatte.persistence.exam;

import java.util.List;

import org.redborn.csatlatte.domain.SubjectVo;

public interface SubjectDao {

	public List<SubjectVo> selectList(int csatSequence, int examSequence);
	public List<SubjectVo> selectListForSolving(int csatSequence, int examSequence);
	public int selectExamTime(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public String selectSubjectName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	public int insert(SubjectVo subjectVo);
	public int delete(int csatSequence, int examSequence);
	
}

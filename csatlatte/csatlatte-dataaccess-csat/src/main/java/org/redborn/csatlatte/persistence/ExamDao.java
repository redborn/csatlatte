package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.ExamVo;

public interface ExamDao {
	
	public int selectOneCountMax(int csatSequence);
	public List<ExamVo> selectListExam(String year, int yearStudedntSequence);
	public List<String> selectListYear(int yearStudentSequence);
	public List<ExamVo> selectListExamForManage(int csatSequence);
	public int insert(ExamVo examVo);
	public int update(ExamVo examVo);
	public int delete(int csatSequence, int examSequence);
	public List<ExamVo> selectListExamOneForManage(int csatSequence, int examSequence);
	
}

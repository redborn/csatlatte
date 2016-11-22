package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.ExamDDayVo;
import org.redborn.csatlatte.domain.ExamVo;

public interface ExamDao {
	
	public int selectOneCountMax(int csatSequence);
	public ExamDDayVo selectOneDDay(int csatSequence);
	public List<ExamVo> selectListDetailForManage(int csatSequence, int examSequence);
	public List<ExamVo> selectListExamForRating(String year, int yearStudedntSequence);
	public List<ExamVo> selectListExamForSolving(String year, int yearStudentSequence);
	public List<String> selectListYearForRating(int yearStudentSequence);
	public List<String> selectListYearForSolving(int yearStudentSequence);
	public List<ExamVo> selectListExamForManage(int csatSequence);
	public String selectExamName(int csatSequence, int examSequence);
	public int insert(ExamVo examVo);
	public int update(ExamVo examVo);
	public int delete(int csatSequence, int examSequence);
	
}

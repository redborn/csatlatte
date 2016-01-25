package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.InstitutionVo;

public interface ExamService {

	public boolean checkForDelete(int csatSequence, int examSequence);
	public List<CsatVo> csatList();
	public List<ExamVo> list(int csatSequence);
	public List<ExamVo> listForManage(int csatSequence);
	public int register(ExamVo examVo);
	public int modify(ExamVo examVo);
	public int delete(int csatSequence, int examSequence);
	public int amountExam(int csatSequence, String search);
	public List<InstitutionVo> institutionList();
	public List<ExamVo> detail(int csatSequence, int examSequence);
	public List<ExamVo> listForRatingManage(int csatSequence);
	public List<ExamVo> listForRatingCreate(int csatSequence);
	public int ratingStudentCount(int csatSequence, int examSequence);
	public boolean deleteAverage(int csatSequence, int examSequence);
	public boolean deleteSection(int csatSequence, int examSequence);
	public boolean deleteSubject(int csatSequence, int examSequence);
	public boolean deleteRatingCut(int csatSequence, int examSequence);
	public boolean deleteStudentScore(int csatSequence, int examSequence);
	
}

package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.GradeVo;
import org.redborn.csatlatte.domain.InstitutionVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

public interface ExamService {

	public int examCountMax(int csatSequence);
	public List<CsatVo> csatList();
	public List<String> yearList(int yearStudentSequence);
	public List<ExamVo> list(String year, int yearStudentSequence);
	public List<ExamVo> listForManage(int csatSequence);
	public List<AverageVo> averageList(int csatSequence, int examSequence);
	public List<SectionVo> sectionList(int csatSequence, int examSequence);
	public List<SubjectVo> subjectList(int csatSequence, int examSequence);
	public int register(ExamVo examVo);
	public int modify(ExamVo examVo);
	public int delete(int csatSequence, int examSequence);
	public List<InstitutionVo> institutionList();
	public List<ExamVo> detail(int csatSequence, int examSequence);
	public List<ExamVo> listForRatingManage(int csatSequence);
	public List<ExamVo> listForRatingCreate(int csatSequence);
	public List<GradeVo> examStudentList(int csatSequence, int examSequence);
	
}

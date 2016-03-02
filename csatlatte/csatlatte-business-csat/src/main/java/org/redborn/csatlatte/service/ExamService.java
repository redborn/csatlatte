package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.GradeVo;
import org.redborn.csatlatte.domain.InstitutionVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

/**
 * 시험 서비스입니다.
 */
public interface ExamService {

	/**
	 * 수능정보입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @return
	 */
	public CsatVo getCsat(int csatSequence);
	
	/**
	 * 수능 목록입니다.
	 * 
	 * @return
	 */
	public List<CsatVo> csatList();
	
	/**
	 * 모의고사 목록입니다.
	 * 
	 * @param year 연도
	 * @param yearStudentSequence 학년 일련번호
	 * @return
	 */
	public Object list(String year, int yearStudentSequence);
	
	/**
	 * 모의고사 연도 목록입니다.
	 * 
	 * @param yearStudentSequence 학년 일련번호
	 * @return
	 */
	public List<String> yearList(int yearStudentSequence);
	
	/**
	 * 모의고사 관리 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @return
	 */
	public List<ExamVo> listForManage(int csatSequence);
	
	/**
	 * 평균 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return
	 */
	public List<AverageVo> averageList(int csatSequence, int examSequence);
	
	/**
	 * 영역 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return
	 */
	public List<SectionVo> sectionList(int csatSequence, int examSequence);
	
	/**
	 * 과목 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return
	 */
	public List<SubjectVo> subjectList(int csatSequence, int examSequence);
	
	/**
	 * 모의고사를 추가합니다.
	 * 
	 * @param examVo 모의고사 값
	 * @return
	 */
	public int register(ExamVo examVo);
	
	/**
	 * 모의고사를 수정합니다.
	 * 
	 * @param examVo 모의고사 값
	 * @return
	 */
	public int modify(ExamVo examVo);
	
	/**
	 * 모의고사를 삭제합니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return
	 */
	public int delete(int csatSequence, int examSequence);
	
	/**
	 * 주관교육청 목록입니다.
	 * 
	 * @return
	 */
	public List<InstitutionVo> institutionList();
	
	/**
	 * 모의고사 상세정보입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return
	 */
	public List<ExamVo> detail(int csatSequence, int examSequence);
	
	/**
	 * 등급컷 관리 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @return
	 */
	public List<ExamVo> listForRatingManage(int csatSequence);
	
	/**
	 * 등급컷 추가 모의고사 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @return
	 */
	public List<ExamVo> listForRatingCreate(int csatSequence);
	
	/**
	 * 모의고사 학생 성적 등록 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return
	 */
	public List<GradeVo> examStudentList(int csatSequence, int examSequence);
	
}

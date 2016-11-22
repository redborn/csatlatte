package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamDDayVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.GradeVo;
import org.redborn.csatlatte.domain.InstitutionVo;
import org.redborn.csatlatte.domain.QuestionVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;

/**
 * 시험 서비스입니다.
 */
public interface ExamService {

	/**
	 * 수능 정보 입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @return 수능 정보
	 */
	public CsatVo getCsat(int csatSequence);
	
	/**
	 * 시험 시간 입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 시험 시간
	 */
	public int getExamTime(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 시험 명 입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @return 시험 명
	 */
	public String getName(int csatSequence, int examSequence);
	
	/**
	 * 과목 명 입니다.
	 *
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 과목 명
	 */
	public String getSubjectName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 수능 리스트입니다.
	 * 
	 * @return 수능 리스트
	 */
	public List<CsatVo> csatList();
	
	/**
	 * 등급컷 모의고사 리스트입니다.
	 * 
	 * @param year 연도
	 * @param yearStudentSequence 학년 일련번호
	 * @return 모의고사 리스트
	 */
	public List<ExamVo> listForRating(String year, int yearStudentSequence);
	/**
	 * 모의고사 풀이 모의고사 리스트입니다.
	 * 
	 * @param year 연도
	 * @param yearStudentSequence 학년 일련번호
	 * @return 모의고사 리스트
	 */
	public List<ExamVo> listForSolving(String year, int yearStudentSequence);
	
	/**
	 * 등급컷 모의고사 연도 리스트입니다.
	 * 
	 * @param yearStudentSequence 학년 일련번호
	 * @return 모의고사 연도 리스트
	 */
	public List<String> yearListForRating(int yearStudentSequence);
	
	/**
	 * 모의고사 풀이 연도 리스트 입니다.
	 * 
	 * @param yearStudentSequence 학년 일련번호
	 * @return 모의고사 연도 리스트
	 */
	public List<String> yearListForSolving(int yearStudentSequence);
	
	/**
	 * 모의고사 관리 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @return 모의고사 리스트
	 */
	public List<ExamVo> listForManage(int csatSequence);
	
	/**
	 * 평균 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return 평균 리스트
	 */
	public List<AverageVo> averageList(int csatSequence, int examSequence);
	
	/**
	 * 영역 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return 영역 리스트
	 */
	public List<SectionVo> sectionList(int csatSequence, int examSequence);
	
	/**
	 * 과목 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return 과목 리스트
	 */
	public List<SubjectVo> subjectList(int csatSequence, int examSequence);
	
	/**
	 * 모의고사 풀이 과목 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return 과목 리스트
	 */
	public List<SubjectVo> subjectListForSolving(int csatSequence, int examSequence);
	
	/**
	 * 모의고사를 추가합니다.
	 * 
	 * @param examVo 모의고사 값
	 * @return 모의고사 추가 성공 여부
	 */
	public boolean register(ExamVo examVo);
	
	/**
	 * 모의고사를 수정합니다.
	 * 
	 * @param examVo 모의고사 값
	 * @return 모의고사 수정 성공 여부
	 */
	public boolean modify(ExamVo examVo);
	
	/**
	 * 모의고사를 삭제합니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return 모의고사 삭제 성공 여부
	 */
	public boolean delete(int csatSequence, int examSequence);
	
	/**
	 * 주관교육청 리스트입니다.
	 * 
	 * @return 주관교육청 리스트
	 */
	public List<InstitutionVo> institutionList();
	
	/**
	 * 문제 리스트 입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 문제 리스트
	 */
	public List<QuestionVo> questionList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 모의고사 정보입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return 모의고사 정보
	 */
	public List<ExamVo> detail(int csatSequence, int examSequence);
	
	/**
	 * 등급컷 관리 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @return 등급컷 리스트
	 */
	public List<ExamVo> listForRatingManage(int csatSequence);
	
	/**
	 * 등급컷 추가 모의고사 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @return 등급컷 모의고사 리스트
	 */
	public List<ExamVo> listForRatingCreate(int csatSequence);
	
	/**
	 * 모의고사 학생 성적 등록 리스트입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @return 모의고사 학생 성적 등록 리스트
	 */
	public List<GradeVo> examStudentList(int csatSequence, int examSequence);
	
	/**
	 * 
	 * 시험 디데이입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @return D-day
	 */
	public ExamDDayVo examDday(int csatSequence);
	
}

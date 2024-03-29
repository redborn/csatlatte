package org.redborn.csatlatte.service;

import java.io.InputStream;
import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.CorrectAnswerVo;
import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.GradeVo;
import org.redborn.csatlatte.domain.InstitutionVo;
import org.redborn.csatlatte.domain.QuestionVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.redborn.csatlatte.domain.TextVo;

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
	 * 문제 입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @return 문제 정보
	 */
	public QuestionVo question(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence);
	
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
	 * 모의고사 풀기 채점입니다.
	 * 
	 * @param questionNumber 사용자가 선택한 답안
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 채점 결과
	 */
	public List<Boolean> marking(List<Integer> questionNumber, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 문제 채점입니다.
	 * 
	 * @param answer 사용자가 선택한 답안
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @return 채점 결과
	 */
	public Boolean marking(int answer, int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence);
	
	/**
	 * 모의고사 풀기 채점 점수입니다.
	 * 
	 * @param questionNumber 사용자가 선택한 답안
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 모의고사 점수
	 */
	public int calculateScore(List<Integer> questionNumber, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 점수에 해당하는 등급을 구합니다.
	 * 
	 * @param score 원점수
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 등급
	 */
	public int calculateRating(int score, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 점수에 해당하는 표준점수를 구합니다.
	 * 
	 * @param score 원점수
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 표준점수
	 */
	public int calculateStandardScore(int score, int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 객관식 정답 및 해설 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 객관식 정답, 해설 목록
	 */
	public List<CorrectAnswerVo> objectQuestionCorrectAnswerList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 객관식 정답 및 해설입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @return 객관식 정답, 해설
	 */
	public CorrectAnswerVo objectQuestionCorrectAnswer(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence);
	
	/**
	 * 지문 목록입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 지문 목록
	 */
	public List<TextVo> textList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 듣기 파일입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 듣기 파일 InputStream
	 */
	public InputStream getInputStream(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 듣기 파일 존재 여부입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 듣기 파일 유무
	 */
	public boolean isListeningFile(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);
	
	/**
	 * 듣기 파일 이름입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @return 듣기 파일 이름
	 */
	public String getFileName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence);

	/**
	 * 지문 이미지 파일입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param textSequence 지문 일련번호
	 * @param imageSequence 이미지 일린변호
	 * @return 지문 이미지 파일 InputStream
	 */
	public InputStream getTextImageInputStream(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence, int imageSequence);
	
	/**
	 * 지문 이미지 파일 존재 여부입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param textSequence 지문 일련번호
	 * @param imageSequence 이미지 일린변호
	 * @return 지문 이미지 파일 유무
	 */
	public boolean isTextImageFile(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence, int imageSequence);
	
	/**
	 * 지문 이미지 파일 이름입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param textSequence 지문 일련번호
	 * @param imageSequence 이미지 일린변호
	 * @return 지문 이미지 파일 이름
	 */
	public String getTextImageFileName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int textSequence, int imageSequence);
	
	/**
	 * 문제 이미지 파일입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @param imageSequence 이미지 일린변호
	 * @return 문제 이미지 파일 InputStream
	 */
	public InputStream getQuestionImageInputStream(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int imageSequence);
	
	/**
	 * 문제 이미지 파일 존재 여부입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @param imageSequence 이미지 일린변호
	 * @return 문제 이미지 파일 유무
	 */
	public boolean isQuestionImageFile(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int imageSequence);
	
	/**
	 * 문제 이미지 파일 이름입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @param imageSequence 이미지 일린변호
	 * @return 문제 이미지 파일 이름
	 */
	public String getQuestionImageFileName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int imageSequence);
	
	/**
	 * 문항 이미지 파일입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @param objectItemSequence 문항 일련번호
	 * @param imageSequence 이미지 일린변호
	 * @return 문제 이미지 파일 InputStream
	 */
	public InputStream getObjectItemImageInputStream(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int objectItemSequence, int imageSequence);
	
	/**
	 * 문항 이미지 파일 존재 여부입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @param objectItemSequence 문항 일련번호
	 * @param imageSequence 이미지 일린변호
	 * @return 문항 이미지 파일 유무
	 */
	public boolean isObjectItemImageFile(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int objectItemSequence, int imageSequence);
	
	/**
	 * 문항 이미지 파일 이름입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @param objectItemSequence 문항 일련번호
	 * @param imageSequence 이미지 일린변호
	 * @return 문항 이미지 파일 이름
	 */
	public String getObjectItemImageFileName(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence, int objectItemSequence, int imageSequence);
	
	/**
	 * 임의의 문제 입니다.
	 * 
	 * @param yearStudentSequenceList 학년 일련번호 목록
	 * @param subjectSequenceList 과목 일련번호 목록
	 * @return 임의의 문제 정보
	 */
	public QuestionVo getRandomQuestion(List<Integer> yearStudentSequence, List<Integer> subjectSequence);
	
	/**
	 * 지문입니다.
	 * 
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 * @param sectionSequence 영역 일련번호
	 * @param subjectSequence 과목 일련번호
	 * @param questionSequence 문제 일련번호
	 * @return 지문 정보
	 */
	public TextVo getText(int csatSequence, int examSequence, int sectionSequence, int subjectSequence, int questionSequence);
	
}

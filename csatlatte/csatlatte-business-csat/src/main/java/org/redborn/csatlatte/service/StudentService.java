package org.redborn.csatlatte.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.SecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.domain.YearStudentVo;

/**
 * 학생서비스 입니다.
 */
public interface StudentService {

	/**
	 * 비밀번호를 검사합니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @param password 비밀번호
	 * @return 비밀번호 일치 여부
	 */
	public boolean checkPassword(int studentSequence, String password);
	
	/**
	 * 비밀번호를 변경합니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @param password 비밀번호
	 * @param newPassword 새로운 비밀번호
	 * @return 비밀번호 변경 성공 여부
	 */
	public boolean changePassword(int studentSequence, String password, String newPassword);
	
	/**
	 * 비밀번호를 변경합니다.
	 * 
	 * @param studentId 학생 아이디
	 * @param securityAnswer 보안답변
	 * @param newPassword 새로운 비밀번호
	 * @return 비밀번호 변경 성공 여부
	 */
	public boolean changePassword(String studentId, String securityAnswer, String newPassword);
	
	/**
	 * 정보를 변경합니다.
	 * 
	 * @param studentVo 학생 값
	 * @param photo 사진
	 * @param photoDelete 삭제할 사진
	 * @return 정보 변경 성공 여부
	 */
	public boolean changeInformation(StudentVo studentVo, File photo, boolean photoDelete);
	
	/**
	 * 보안질문을 변경합니다.
	 * 
	 * @param studentSecurityQuestionVo 보안질문 값
	 * @return 보안질문 변경 성공 여부
	 */
	public boolean changeSecurity(StudentSecurityQuestionVo studentSecurityQuestionVo);
	
	/**
	 * 새로운 아이디를 생성합니다.
	 * 
	 * @param studentVo 학생 값
	 * @param studentSecurityQuestionVo 보안질문 값
	 * @param photo 사진
	 * @return 아이디 생성 성공 여부
	 */
	public boolean join(StudentVo studentVo, StudentSecurityQuestionVo studentSecurityQuestionVo, File photo);
	
	/**
	 * 아이디를 찾습니다.
	 * 
	 * @param nickname 닉네임
	 * @param securityAnswer 보안답변
	 * @return 아이디
	 */
	public String findId(String nickname, String securityAnswer);
	
	/**
	 * 비밀번호를 찾습니다.
	 * 
	 * @param id 아이디
	 * @param securityAnswer 보안답변
	 * @return 보안답변 일치 여부
	 */
	public boolean isPassword(String id, String securityAnswer);
	
	/**
	 * 아이디 중복을 확인합니다.
	 * 
	 * @param studentId 학생 아이디
	 * @return 아이디 중복 여부
	 */
	public boolean isId(String studentId);
	
	/**
	 * 닉네임 중복을 확인합니다.
	 * 
	 * @param nickname 닉네임
	 * @return 닉네임 중복 여부
	 */
	public boolean isNickname(String nickname);
	
	/**
	 * 학생 정보입니다.
	 * 
	 * @param id 아이디
	 * @param password 비밀번호
	 * @return 학생 정보
	 */
	public StudentVo information(String id, String password);
	
	/**
	 * 학생 정보입니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @return 학생 정보
	 */
	public StudentVo information(int studentSequence);
	
	/**
	 * 학생 접속을 처리합니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @param userAgent 학생 기기
	 * @param sessionId 학생 아이디
	 * @param ip 아이피
	 * @return 접속 성공 여부
	 */
	public boolean connection(int studentSequence, String userAgent, String sessionId, String ip);
	
	/**
	 * 아이디를 잠굽니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @return 아이디 잠금 성공 여부
	 */
	public boolean lock(int studentSequence);
	
	/**
	 * 아이디 잠금을 해제합니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @return 아이디 잠금 해제 성공 여부
	 */
	public boolean unlock(int studentSequence);
	
	/**
	 * 일간 가입자 통계입니다.
	 * 
	 * @param ymd 연월일
	 * @return 시간별 가입자 리스트
	 */
	public List<CountVo> dailyJoinCountList(String ymd);
	
	/**
	 * 월간 가입자 통계입니다.
	 * 
	 * @param ym 연월
	 * @return 일별 가입자 수 리스트
	 */
	public List<CountVo> monthlyJoinCountList(String ym);
	
	/**
	 * 연간 가입자 통계입니다.
	 * 
	 * @param year 연도
	 * @return 월별 가입자 수 리스트
	 */
	public List<CountVo> annualJoinCountList(String year);
	
	/**
	 * 일간 접속 통계입니다.
	 * 
	 * @param ymd 연월일
	 * @return 시간별 접속자 수 리스트
	 */
	public List<CountVo> dailyConnectionCount(String ymd);
	
	/**
	 * 월간 접속 통계입니다.
	 * 
	 * @param ym 연월
	 * @return 일별 접속자 수 리스트
	 */
	public List<CountVo> monthlyConnectionCount(String ym);
	
	/**
	 * 연간 접속 통계입니다.
	 * 
	 * @param year 연도
	 * @return 월별 접속자 수 리스트
	 */
	public List<CountVo> annualConnectionCount(String year);
	
	/**
	 * 학생 리스트입니다.
	 * 
	 * @param search 검색
	 * @param pageNumber 페이지 번호
	 * @return 학생 리스트
	 */
	public List<StudentVo> userList(String search, int pageNumber);
	
	/**
	 * 보안질문입니다.
	 * 
	 * @param nickname 닉네임
	 * @return 보안질문
	 */
	public String securityQuestion(String nickname);
	
	/**
	 * 보안질문입니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @return 보안질문
	 */
	public String securityQuestion(int studentSequence);
	
	/**
	 * 학생 수입니다.
	 * 
	 * @param search 검색
	 * @return 학생 수
	 */
	public int amountStudent(String search);
	
	/**
	 * 학년 리스트입니다.
	 * 
	 * @return 학년 리스트
	 */
	public List<YearStudentVo> yearStudentList();
	
	/**
	 * 보안질문 리스트입니다.
	 * 
	 * @return 보안질문 리스트
	 */
	public List<SecurityQuestionVo> securityQuestionList();
	
	/**
	 * 학생 일련번호입니다.
	 * 
	 * @param studentId 학생 아이디
	 * @return 학생 일련번호
	 */
	public int getStudentSequence(String studentId);
	
	/**
	 * 프로필 사진 파일명입니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @return 학생 사진 이름
	 */
	public String getPhotoName(int studentSequence);
	
	/**
	 * InputStream입니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @return InputStream
	 */
	public InputStream getInputStream(int studentSequence);
	
}

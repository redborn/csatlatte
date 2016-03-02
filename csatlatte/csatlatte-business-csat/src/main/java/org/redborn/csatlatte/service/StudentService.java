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
	 * @param studentSequence 사용자 일련번호
	 * @param password 비밀번호
	 * @return
	 */
	public boolean checkPassword(int studentSequence, String password);
	
	/**
	 * 비밀번호를 변경합니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @param password 비밀번호
	 * @param newPassword 새로운 비밀번호
	 * @return
	 */
	public boolean changePassword(int studentSequence, String password, String newPassword);
	
	/**
	 * 비밀번호를 변경합니다.
	 * 
	 * @param studentId 사용자 아이디
	 * @param securityAnswer 보안답변
	 * @param newPassword 새로운 비밀번호
	 * @return
	 */
	public boolean changePassword(String studentId, String securityAnswer, String newPassword);
	
	/**
	 * 정보를 변경합니다.
	 * 
	 * @param studentVo 사용자 값
	 * @param photo 사진
	 * @param photoDelete 삭제할 사진
	 * @return
	 */
	public boolean changeInformation(StudentVo studentVo, File photo, boolean photoDelete);
	
	/**
	 * 보안질문을 변경합니다.
	 * 
	 * @param studentSecurityQuestionVo 보안질문 값
	 * @return
	 */
	public boolean changeSecurity(StudentSecurityQuestionVo studentSecurityQuestionVo);
	
	/**
	 * 새로운 아이디를 생성합니다.
	 * 
	 * @param studentVo 사용자 값
	 * @param studentSecurityQuestionVo 보안질문 값
	 * @param photo 사진
	 * @return
	 */
	public boolean join(StudentVo studentVo, StudentSecurityQuestionVo studentSecurityQuestionVo, File photo);
	
	/**
	 * 아이디를 찾습니다.
	 * 
	 * @param nickname 닉네임
	 * @param securityAnswer 보안답변
	 * @return
	 */
	public String findId(String nickname, String securityAnswer);
	
	/**
	 * 비밀번호를 찾습니다.
	 * 
	 * @param id 아이디
	 * @param securityAnswer 보안답변
	 * @return
	 */
	public boolean isPassword(String id, String securityAnswer);
	
	/**
	 * 아이디 중복을 확인합니다.
	 * 
	 * @param studentId 학생 아이디
	 * @return
	 */
	public boolean isId(String studentId);
	
	/**
	 * 닉네임 중복을 확인합니다.
	 * 
	 * @param nickname 닉네임
	 * @return
	 */
	public boolean isNickname(String nickname);
	
	/**
	 * 사용자 상세정보입니다.
	 * 
	 * @param id 아이디
	 * @param password 비밀번호
	 * @return
	 */
	public StudentVo information(String id, String password);
	
	/**
	 * 사용자 상세정보입니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public StudentVo information(int studentSequence);
	
	/**
	 * 사용자 접속을 처리합니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @param userAgent 사용자 기기
	 * @param sessionId 사용자 아이디
	 * @param ip 아이피
	 * @return
	 */
	public boolean connection(int studentSequence, String userAgent, String sessionId, String ip);
	
	/**
	 * 아이디를 블라인드합니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public boolean lock(int studentSequence);
	
	/**
	 * 아이디의 블라인드를 해제합니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public boolean unlock(int studentSequence);
	
	/**
	 * 일간 가입자 통계입니다.
	 * 
	 * @param ymd 연월일
	 * @return
	 */
	public List<CountVo> dailyJoinCountList(String ymd);
	
	/**
	 * 월간 가입자 통계입니다.
	 * 
	 * @param ym 연월
	 * @return
	 */
	public List<CountVo> monthlyJoinCountList(String ym);
	
	/**
	 * 연간 가입자 통계입니다.
	 * 
	 * @param year 연도
	 * @return
	 */
	public List<CountVo> annualJoinCountList(String year);
	
	/**
	 * 일간 접속 통계입니다.
	 * 
	 * @param ymd 연월일
	 * @return
	 */
	public List<CountVo> dailyConnectionCount(String ymd);
	
	/**
	 * 월간 접속 통계입니다.
	 * 
	 * @param ym 연월
	 * @return
	 */
	public List<CountVo> monthlyConnectionCount(String ym);
	
	/**
	 * 연간 접속 통계입니다.
	 * 
	 * @param year 연도
	 * @return
	 */
	public List<CountVo> annualConnectionCount(String year);
	
	/**
	 * 사용자 목록입니다.
	 * 
	 * @param search 검색
	 * @param pageNumber 페이지 번호
	 * @return
	 */
	public List<StudentVo> userList(String search, int pageNumber);
	
	/**
	 * 보안질문입니다.
	 * 
	 * @param nickname 닉네임
	 * @return
	 */
	public String securityQuestion(String nickname);
	
	/**
	 * 보안질문입니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public String securityQuestion(int studentSequence);
	
	/**
	 * 사용자 수입니다.
	 * 
	 * @param search 검색
	 * @return
	 */
	public int amountStudent(String search);
	
	/**
	 * 학년 목록입니다.
	 * 
	 * @return
	 */
	public List<YearStudentVo> yearStudentList();
	
	/**
	 * 보안질문 목록입니다.
	 * 
	 * @return
	 */
	public List<SecurityQuestionVo> securityQuestionList();
	
	/**
	 * 사용자 일련번호입니다.
	 * 
	 * @param studentId 사용자 아이디
	 * @return
	 */
	public int getStudentSequence(String studentId);
	
	/**
	 * 프로필 사진 파일명입니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 * @return
	 */
	public String getPhotoName(int studentSequence);
	
	/**
	 * InputStream입니다.
	 * 
	 * @param studentSequence 사용자 일련번호
	 */
	public InputStream getInputStream(int studentSequence);
	
}

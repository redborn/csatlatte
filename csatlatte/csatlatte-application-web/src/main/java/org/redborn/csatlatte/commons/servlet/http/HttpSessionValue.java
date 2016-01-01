package org.redborn.csatlatte.commons.servlet.http;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HttpSession의 값을 처리 합니다.
 * 
 * @author 최순열
 *
 */
@Service
public class HttpSessionValue {
	
	private final static String STUDENT_SEQUENCE = "studentSequence";
	private final static String NICKNAME = "nickname";
	private final static String RULE_SEQUENCE = "ruleSequence";
	private final static String ID = "id";
	public final static int STUDENT = 1;
	public final static int MANAGER = 2;
	@Autowired
	private HttpSession session;
	
	/**
	 * 사용자를 입력 합니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @param nickname 닉네임
	 * @param ruleSequence 규칙 일련번호
	 */
	public void setUser(String id, int studentSequence, String nickname, int ruleSequence) {
		this.session.setAttribute(ID, id);
		this.session.setAttribute(STUDENT_SEQUENCE, studentSequence);
		this.session.setAttribute(NICKNAME, nickname);
		this.session.setAttribute(RULE_SEQUENCE, ruleSequence);
	}
	
	public String getId() {
		return (String) this.session.getAttribute(ID);
	}
	
	/**
	 * 학생 일련번호 입니다.
	 * 
	 * @return 학생 일련번호
	 */
	public int getStudentSequence() {
		return getStudentSequence(this.session);
	}
	
	/**
	 * 학생 일련번호 입니다.
	 * 
	 * @param session 세션
	 * @return 학생 일련번호
	 */
	public static int getStudentSequence(HttpSession session) {
		Integer studentSequence = (Integer) session.getAttribute(STUDENT_SEQUENCE);
		return studentSequence != null ? studentSequence : 0;
	}
	
	/**
	 * 규칙 일련번호 입니다.
	 * 
	 * @return 규칙 일련번호
	 */
	public int getRuleSequence() {
		return getRuleSequence(this.session);
	}
	
	/**
	 * 규칙 일련번호 입니다.
	 * 
	 * @param session 세션
	 * @return 규칙 일련번호
	 */
	public static int getRuleSequence(HttpSession session) {
		Integer ruleSequence = (Integer) session.getAttribute(RULE_SEQUENCE);
		return ruleSequence != null ? ruleSequence : 0;
	}
	
	/**
	 * 닉네임 입니다.
	 * 
	 * @return 닉네임
	 */
	public String getNickname() {
		return getNickname(this.session);
	}
	
	/**
	 * 닉네임 입니다.
	 * 
	 * @param session 세션
	 * @return 닉네임
	 */
	public static String getNickname(HttpSession session) {
		return (String) session.getAttribute(NICKNAME);
	}
	
	/**
	 * 세션을 초기화 합니다.
	 */
	public void invalidate() {
		this.session.invalidate();
	}
	
}
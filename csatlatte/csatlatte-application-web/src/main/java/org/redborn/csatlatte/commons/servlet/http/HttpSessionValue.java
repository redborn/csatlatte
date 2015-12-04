package org.redborn.csatlatte.commons.servlet.http;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpSessionValue {
	
	private final static String USER_SEQUENCE = "userSequence";
	private final static String NICKNAME = "nickName";
	private final static String RULE_SEQUENCE = "ruleSequence";
	public final static int STUDENT = 1;
	public final static int ADMINISTRATOR = 2;
	@Autowired
	private HttpSession session;
	
	public void setUser(int userSequence, String nickname, int ruleSequence) {
		this.session.setAttribute(USER_SEQUENCE, userSequence);
		this.session.setAttribute(NICKNAME, nickname);
		this.session.setAttribute(RULE_SEQUENCE, ruleSequence);
	}
	
	public int getUserSequence() {
		return getUserSequence(this.session);
	}
	
	public static int getUserSequence(HttpSession session) {
		Integer userSequence = (Integer) session.getAttribute(USER_SEQUENCE);
		return userSequence != null ? userSequence : 0;
	}
	
	public int getRuleSequence() {
		return getRuleSequence(this.session);
	}
	
	public static int getRuleSequence(HttpSession session) {
		Integer ruleSequence = (Integer) session.getAttribute(RULE_SEQUENCE);
		return ruleSequence != null ? ruleSequence : 0;
	}
	
	public String getNickname() {
		return getNickname(this.session);
	}
	
	public static String getNickname(HttpSession session) {
		return (String) session.getAttribute(NICKNAME);
	}
	
	public void invalidate() {
		this.session.invalidate();
	}
	
}
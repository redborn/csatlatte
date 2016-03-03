package org.redborn.csatlatte.commons.tag.el.servlet.http;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;

/**
 * 닉네임을 출력하는 Tablib 입니다.
 * 
 * @author 최순열
 *
 */
@SuppressWarnings("serial")
public class NicknameTag extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print(HttpSessionValue.getNickname(pageContext.getSession()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
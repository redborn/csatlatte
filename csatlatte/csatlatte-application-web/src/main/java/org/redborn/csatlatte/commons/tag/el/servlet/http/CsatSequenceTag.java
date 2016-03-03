package org.redborn.csatlatte.commons.tag.el.servlet.http;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;

/**
 * 수능 일련번호를 출력하는 Taglib 입니다.
 * 
 * @author 최순열
 *
 */
@SuppressWarnings("serial")
public class CsatSequenceTag extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print(HttpSessionValue.getCsatSequence(pageContext.getSession()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}

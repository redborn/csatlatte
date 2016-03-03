package org.redborn.csatlatte.commons.tag.el.servlet.http;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;

/**
 * 로그인 여부를 판단하는 Taglib 입니다.
 * 
 * @author 최순열
 *
 */
@SuppressWarnings("serial")
public class IsLoginTag extends ConditionalTagSupport  {
	
	@Override
	protected boolean condition() throws JspTagException {
		return HttpSessionValue.getRuleSequence(pageContext.getSession()) > 0;
	}
	
}

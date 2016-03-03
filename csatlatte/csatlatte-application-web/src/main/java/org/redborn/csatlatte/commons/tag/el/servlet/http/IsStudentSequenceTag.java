package org.redborn.csatlatte.commons.tag.el.servlet.http;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;

/**
 * 학생 일련번호 확인 Taglib 입니다.
 * 
 * @author 최순열
 *
 */
@SuppressWarnings("serial")
public class IsStudentSequenceTag extends ConditionalTagSupport {
	
	private int studentSequence;

	public void setStudentSequence(int studentSequence) {
		this.studentSequence = studentSequence;
	}

	@Override
	protected boolean condition() throws JspTagException {
		return HttpSessionValue.getStudentSequence(pageContext.getSession()) == studentSequence;
	}

}
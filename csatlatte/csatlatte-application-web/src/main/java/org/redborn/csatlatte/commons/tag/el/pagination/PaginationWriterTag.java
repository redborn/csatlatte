package org.redborn.csatlatte.commons.tag.el.pagination;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.redborn.csatlatte.commons.pagination.PaginationWriter;

/**
 * PaginationWriter 처리하는 Taglib 입니다.
 * 
 * @author 최순열
 *
 */
@SuppressWarnings("serial")
public class PaginationWriterTag extends TagSupport {
	
	private PaginationWriter paginationWriter;

	public void setValue(PaginationWriter paginationWriter) {
		this.paginationWriter = paginationWriter;
	}
	
	@Override
	public int doStartTag() throws JspException {
		if (paginationWriter != null) {
			try {
				pageContext.getOut().print(paginationWriter.write());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return super.doStartTag();
	}

}

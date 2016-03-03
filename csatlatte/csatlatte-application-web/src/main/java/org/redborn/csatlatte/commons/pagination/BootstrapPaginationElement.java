package org.redborn.csatlatte.commons.pagination;

/**
 * Bootstrap 페이징 처리시 사용되는 element입니다.
 * 
 * @author 최순열
 *
 */
public class BootstrapPaginationElement extends PaginationElement {

	public BootstrapPaginationElement() {
		super(UL, LI, "<span aria-hidden=\"true\">&laquo;</span>", "<span aria-hidden=\"true\">&raquo;</span>", "<span aria-hidden=\"true\">&lsaquo;</span>", "<span aria-hidden=\"true\">&rsaquo;</span>");
	}
	
}
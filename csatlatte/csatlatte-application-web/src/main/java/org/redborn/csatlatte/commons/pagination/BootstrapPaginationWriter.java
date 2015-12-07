package org.redborn.csatlatte.commons.pagination;

import java.util.Map;

/**
 * Bootstrap 형식으로 페이징 내용을 출력 합니다.
 * 
 * @author 최순열
 *
 */
public class BootstrapPaginationWriter extends PaginationWriter {

	/**
	 * @param pagination 페이징
	 * @param url 경로
	 */
	public BootstrapPaginationWriter(Pagination pagination, String url) {
		this(pagination, url, PAGE_KEY);
	}
	
	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param pageKey 페이지 키
	 */
	public BootstrapPaginationWriter(Pagination pagination, String url, String pageKey) {
		this(pagination, url, null, pageKey);
	}

	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param params 전달인자
	 */
	public BootstrapPaginationWriter(Pagination pagination, String url, Map<String, String> params) {
		this(pagination, url, params, PAGE_KEY);
	}

	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param params 전달인자
	 * @param pageKey 페이지 키
	 */
	public BootstrapPaginationWriter(Pagination pagination, String url, Map<String, String> params, String pageKey) {
		super(pagination, url, params, pageKey, new BootstrapPaginationElement());
		setPageParentAttribute("class", "pagination");
	}

}
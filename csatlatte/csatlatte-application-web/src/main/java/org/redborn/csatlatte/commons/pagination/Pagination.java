package org.redborn.csatlatte.commons.pagination;

/**
 * 페이징 처리에 필요한 영역을 구합니다.
 * 
 * @author 최순열
 *
 */
public class Pagination {

	private int page;
	private int totalCount;
	private int length;
	private int pageLength;
	
	/**
	 * @param page 현재 페이지
	 * @param totalCount 전체 글 수
	 */
	public Pagination(int page, int totalCount) {
		this(page, totalCount, 10);
	}
	
	/**
	 * @param page 현재 페이지
	 * @param totalCount 전체 글 수
	 * @param length 페이지에 보여지는 글 수
	 */
	public Pagination(int page, int totalCount, int length) {
		this(page, totalCount, length, 10);
	}
	
	/**
	 * @param page 현재 페이지
	 * @param totalCount 전체 글 수
	 * @param length 페이지에 보여지는 글 수
	 * @param pageLength 페이지 길이
	 */
	public Pagination(int page, int totalCount, int length, int pageLength) {
		this.page = page;
		this.totalCount = totalCount;
		this.length = length;
		this.pageLength = pageLength;
	}
	
	/**
	 * 시작 페이지를 구합니다.
	 * 
	 * @return 시작 페이지
	 */
	public int getBeginPage() {
		return this.pageLength * ((this.page - 1) / pageLength) + 1;
	}
	
	/**
	 * 현재 페이지를 기준으로 마지막 페이지를 구합니다.
	 * 
	 * @return 현재 마지막 페이지
	 */
	public int getEndPage() {
		int endPage = (((this.page - 1)  / pageLength) + 1) * pageLength;
		int lastPage = getLastPage();
		return endPage < lastPage ? endPage : lastPage;
	}
	
	/**
	 * 마지막 페이지를 구합니다.
	 * 
	 * @return 마지막 페이지
	 */
	public int getLastPage() {
		return (totalCount / length) + (totalCount % length == 0 ? 0 : 1);
	}

	/**
	 * 현재 페이지를 구합니다.
	 * 
	 * @return 현재 페이지
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 총 페이지 수를 구합니다.
	 * 
	 * @return 총 페이지 수
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 페이지에 보여지는 글 수를 구합니다.
	 * 
	 * @return 페이지에 보여지는 글 수
	 */
	public int getLength() {
		return length;
	}

	/**
	 * 페이지 길이를 구합니다.
	 * 
	 * @return 페이지 길이
	 */
	public int getPageLength() {
		return pageLength;
	}
	
	/**
	 * 시작 행을 구합니다.
	 * 
	 * @return 시작 행
	 */
	public int getBeginRow() {
		return page * length - (length - 1);
	}
	
	/**
	 * 마지막 행을 구합니다.
	 * 
	 * @return 마지막 행
	 */
	public int getEndRow() {
		int endRow = page * length;
		return endRow > totalCount ? totalCount : endRow;
	}
	
}

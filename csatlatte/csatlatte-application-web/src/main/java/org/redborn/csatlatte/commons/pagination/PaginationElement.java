package org.redborn.csatlatte.commons.pagination;

/**
 * 페이징 처리시 사용되는 element입니다.
 * 
 * @author 최순열
 *
 */
public class PaginationElement {

	public static final String UL = "ul";
	public static final String LI = "li";
	
	private String pageParentElement;
	private String pageElement;
	
	private String pageFirstElementText;
	private String pagePreviousElementText;
	private String pageNextElementText;
	private String pageLastElementText;
	
	public PaginationElement() {
		this(UL, LI);
	}
	
	/**
	 * @param pageParentElement 페이지 부모 element
	 * @param pageElement 페이지 element
	 */
	public PaginationElement(String pageParentElement, String pageElement) {
		this(pageParentElement, pageElement, "처음", "마지막", "이전", "다음");
	}
	
	/**
	 * @param pageFirstElementText 처음 element 글
	 * @param pageLastElementText 마지막 element 글
	 * @param pagePreviousElementText 이전 element 글
	 * @param pageNextElementText 다음 element 글
	 */
	public PaginationElement(String pageFirstElementText, String pageLastElementText, String pagePreviousElementText, String pageNextElementText) {
		this(UL, LI, pageFirstElementText, pageLastElementText, pagePreviousElementText, pageNextElementText);
	}
	
	/**
	 * @param pageParentElement 페이지 부모 element
	 * @param pageElement 페이지 element
	 * @param pageFirstElementText 처음 element 글
	 * @param pageLastElementText 마지막 element 글
	 * @param pagePreviousElementText 이전 element 글
	 * @param pageNextElementText 다음 element 글
	 */
	public PaginationElement(String pageParentElement, String pageElement, String pageFirstElementText, String pageLastElementText, String pagePreviousElementText, String pageNextElementText) {
		this.pageParentElement = pageParentElement;
		this.pageElement = pageElement;
		this.pageFirstElementText = pageFirstElementText;
		this.pageLastElementText = pageLastElementText;
		this.pagePreviousElementText = pagePreviousElementText;
		this.pageNextElementText = pageNextElementText;
	}
	
	/**
	 * 페이지 부모 element를 구합니다.
	 * 
	 * @return 페이지 부모 element
	 */
	public String getPageParentElement() {
		return pageParentElement;
	}

	/**
	 * 페이지 element를 구합니다.
	 * 
	 * @return 페이지 element
	 */
	public String getPageElement() {
		return pageElement;
	}

	/**
	 * 처음 element 글을 구합니다.
	 * 
	 * @return 처음 element 글
	 */
	public String getPageFirstElementText() {
		return pageFirstElementText;
	}

	/**
	 * 이전 element 글을 구합니다.
	 * 
	 * @return 이전 element 글
	 */
	public String getPagePreviousElementText() {
		return pagePreviousElementText;
	}

	/**
	 * 다음 element 글을 구합니다.
	 * 
	 * @return 다음 element 글
	 */
	public String getPageNextElementText() {
		return pageNextElementText;
	}

	/**
	 * 마지막 element 글을 구합니다.
	 * 
	 * @return 마지막 element 글
	 */
	public String getPageLastElementText() {
		return pageLastElementText;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaginationElement [pageParentElement=");
		builder.append(pageParentElement);
		builder.append(", pageElement=");
		builder.append(pageElement);
		builder.append(", pageFirstElementText=");
		builder.append(pageFirstElementText);
		builder.append(", pagePreviousElementText=");
		builder.append(pagePreviousElementText);
		builder.append(", pageNextElementText=");
		builder.append(pageNextElementText);
		builder.append(", pageLastElementText=");
		builder.append(pageLastElementText);
		builder.append("]");
		return builder.toString();
	}
	
}

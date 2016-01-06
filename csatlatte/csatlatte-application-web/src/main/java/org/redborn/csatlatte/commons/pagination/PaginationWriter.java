package org.redborn.csatlatte.commons.pagination;

import java.util.Iterator;
import java.util.Map;

/**
 *  페이징 내용을 출력 합니다.
 * 
 * @author 최순열
 */
public class PaginationWriter {

	protected static final String PAGE_KEY = "page";
	
	private Pagination pagination;
	private String url;
	
	private String pageParentElementBeginTag;
	private String pageParentElementEndTag;
	private String pageElementBeginTag;
	private String pageElementEndTag;
	
	private String pageElementAttribute;
	private String anchorElementAttribute;
	private String selectAnchorElementAttribute;
	
	private String pageFirstElementText;
	private String pagePreviousElementText;
	private String pageNextElementText;
	private String pageLastElementText;
	
	/**
	 * @param pagination 페이징
	 * @param url 경로
	 */
	public PaginationWriter(Pagination pagination, String url) {
		this(pagination, url, PAGE_KEY);
	}
	
	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param pageKey 페이지 키
	 */
	public PaginationWriter(Pagination pagination, String url, String pageKey) {
		this(pagination, url, pageKey, new PaginationElement());
	}

	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param paginationElement 페이징 element
	 */
	public PaginationWriter(Pagination pagination, String url, PaginationElement paginationElement) {
		this(pagination, url, PAGE_KEY, paginationElement);
	}
	
	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param params 전달인자
	 */
	public PaginationWriter(Pagination pagination, String url, Map<String, String> params) {
		this(pagination, url, params, PAGE_KEY);
	}

	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param params 전달인자
	 * @param pageKey 페이지 키
	 */
	public PaginationWriter(Pagination pagination, String url, Map<String, String> params, String pageKey) {
		this(pagination, url, params, pageKey, new PaginationElement());
	}
	
	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param pageKey 페이지 키
	 * @param paginationElement 페이징 element
	 */
	public PaginationWriter(Pagination pagination, String url, String pageKey, PaginationElement paginationElement) {
		this(pagination, url, null, pageKey, paginationElement);
	}
	
	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param params 페이지 키
	 * @param paginationElement 페이징 element
	 */
	public PaginationWriter(Pagination pagination, String url, Map<String, String> params, PaginationElement paginationElement) {
		this(pagination, url, params, PAGE_KEY, paginationElement);
	}
	
	/**
	 * @param pagination 페이징
	 * @param url 경로
	 * @param params 전달인자
	 * @param pageKey 페이지 키
	 * @param paginationElement 페이징 element
	 */
	public PaginationWriter(Pagination pagination, String url, Map<String, String> params, String pageKey, PaginationElement paginationElement) {
		this.url = url;
		StringBuilder urlStringBuilder = new StringBuilder(url).append("?");
		boolean first = true;
		if (params != null) {
			Iterator<String> iterator = params.keySet().iterator();
			String key;
			while (iterator.hasNext()) {
				key = iterator.next();
				if (!first) {
					urlStringBuilder.append("&amp;");
				} else {
					first = false;
				}
				urlStringBuilder.append(key).append("=").append(params.get(key));
			}
		}
		if (!first) {
			urlStringBuilder.append("&amp;");
		}
		
		urlStringBuilder.append(pageKey).append("=");

		this.url = urlStringBuilder.toString();
		
		this.pagination = pagination;
		this.pageParentElementBeginTag = new StringBuilder("<").append(paginationElement.getPageParentElement()).toString();
		this.pageParentElementEndTag = new StringBuilder("</").append(paginationElement.getPageParentElement()).append(">").toString();
		this.pageElementBeginTag = new StringBuilder("<").append(paginationElement.getPageElement()).toString();
		this.pageElementEndTag = new StringBuilder("</").append(paginationElement.getPageElement()).append(">").toString();
		this.pageFirstElementText = paginationElement.getPageFirstElementText();
		this.pagePreviousElementText = paginationElement.getPagePreviousElementText();
		this.pageNextElementText = paginationElement.getPageNextElementText();
		this.pageLastElementText = paginationElement.getPageLastElementText();
	}
	
	/**
	 * attribute를 설정합니다.
	 * 
	 * @param elementTag 태그
	 * @param key 키
     * @param value	값
	 * @return attribute
	 */
	private String makeAttribute(String elementTag, String key, String value) {
		String makeElementTag = null;
		if (key != null && value != null) {
			makeElementTag = new StringBuilder(elementTag != null ? elementTag : "").append(" ").append(key).append("=").append("'").append(value).append("'").toString();
		} else {
			makeElementTag = elementTag;
		}
		return makeElementTag;
	}
	
	/**
	 * 부모 element의 속성을 추가합니다.
	 * 
	 * @param key 키
	 * @param value 값
	 */
	public void setPageParentAttribute(String key, String value) {
		pageParentElementBeginTag = makeAttribute(pageParentElementBeginTag, key, value);
	}
	
	/**
	 * element의 속성을 추가합니다.
	 * 
	 * @param key 키
	 * @param value 값
	 */
	public void setPageAttribute(String key, String value) {
		pageElementBeginTag = makeAttribute(pageElementBeginTag, key, value);
	}
	
	/**
	 * select element의 속성을 추가합니다.
	 * 
	 * @param key 키
	 * @param value 값
	 */
	public void setSelectPageAttribute(String key, String value) {
		pageElementAttribute = makeAttribute(pageElementBeginTag, key, value);
	}
	
	/**
	 * anchor element의 속성을 추가합니다.
	 * 
	 * @param key 키
	 * @param value 값
	 */
	public void setAnchorAttribute(String key, String value) {
		anchorElementAttribute = makeAttribute(anchorElementAttribute, key, value);
	}
	
	/**
	 * select anchor element의 속성을 추가합니다.
	 * 
	 * @param key 키
	 * @param value 값
	 */
	public void setSelectAnchorAttribute(String key, String value) {
		selectAnchorElementAttribute = makeAttribute(selectAnchorElementAttribute, key, value);
	}
	
	/**
	 * 페이징 내용을 출력합니다.
	 * 
	 * @return 페이징 내용
	 */
	public String write() {
		int page = pagination.getPage();
		int beginPage = pagination.getBeginPage();
		int endPage = pagination.getEndPage();
		int lastPage = pagination.getLastPage();
		StringBuilder paginationStr = new StringBuilder(pageParentElementBeginTag).append(">");
		String anchorElementAttribute = null;
		String selectAnchorElementAttribute = null;
		if (this.anchorElementAttribute == null) {
			anchorElementAttribute = "";
		} else {
			anchorElementAttribute = new StringBuilder(this.anchorElementAttribute).append(" ").toString();
		}
		if (this.selectAnchorElementAttribute == null) {
			selectAnchorElementAttribute = "";
		} else {
			selectAnchorElementAttribute = new StringBuilder(this.selectAnchorElementAttribute).append(" ").toString();
		}
		if (beginPage != 1) {
			paginationStr.append(pageElementBeginTag).append("><a ").append(anchorElementAttribute).append("href='").append(url).append(1).append("'>").append(pageFirstElementText).append("</a>").append(pageElementEndTag);
			paginationStr.append(pageElementBeginTag).append("><a ").append(anchorElementAttribute).append("href='").append(url).append(beginPage - 1).append("'>").append(pagePreviousElementText).append("</a>").append(pageElementEndTag);
		}
		
		for (int i = beginPage; i <= endPage; i++) {
			paginationStr.append(pageElementBeginTag).append(" ").append(i != page ? null : pageElementAttribute).append("><a ").append(i != page ? anchorElementAttribute : selectAnchorElementAttribute).append("href='").append(url).append(i).append("'>").append(i).append("</a>").append(pageElementEndTag);
		}
		
		if (endPage != lastPage) {
			paginationStr.append(pageElementBeginTag).append("><a ").append(anchorElementAttribute).append("href='").append(url).append(endPage + 1).append("'>").append(pageNextElementText).append("</a>").append(pageElementEndTag);
			paginationStr.append(pageElementBeginTag).append("><a ").append(anchorElementAttribute).append("href='").append(url).append(lastPage).append("'>").append(pageLastElementText).append("</a>").append(pageElementEndTag);
		}
		
		paginationStr.append(pageParentElementEndTag);
		return paginationStr.toString();
	}
	
}
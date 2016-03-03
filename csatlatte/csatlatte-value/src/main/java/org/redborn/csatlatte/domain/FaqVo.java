package org.redborn.csatlatte.domain;

public class FaqVo {

	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "FaqVo [title=" + title + ", content=" + content + "]";
	}
	
}

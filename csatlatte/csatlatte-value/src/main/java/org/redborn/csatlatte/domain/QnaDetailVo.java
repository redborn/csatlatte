package org.redborn.csatlatte.domain;

import java.util.List;

public class QnaDetailVo {

	
	private String writeDate;
	private List<String> content;
	private List<QnaFileVo> file;
	
	public String getWriteDate() {
		return writeDate;
	}
	
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	public List<String> getContent() {
		return content;
	}
	
	public void setContent(List<String> content) {
		this.content = content;
	}
	
	public List<QnaFileVo> getFile() {
		return file;
	}
	
	public void setFile(List<QnaFileVo> file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "QnaDetailVo [writeDate=" + writeDate + ", content=" + content
				+ ", file=" + file + "]";
	}
	
}

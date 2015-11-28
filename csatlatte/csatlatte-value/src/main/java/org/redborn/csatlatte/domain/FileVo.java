package org.redborn.csatlatte.domain;

public class FileVo {
	
	private String fileName;
	private String fileCode;
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileCode() {
		return fileCode;
	}
	
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	
	@Override
	public String toString() {
		return "FileVo [fileName=" + fileName + ", fileCode=" + fileCode + "]";
	}
	
}

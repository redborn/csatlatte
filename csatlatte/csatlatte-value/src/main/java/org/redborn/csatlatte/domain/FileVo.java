package org.redborn.csatlatte.domain;

public class FileVo {
	
	private int qnaSequence;
	private int fileSequence;
	private String fileName;
	private String fileCode;
	
	public int getQnaSequence() {
		return qnaSequence;
	}

	public void setQnaSequence(int qnaSequence) {
		this.qnaSequence = qnaSequence;
	}

	public int getFileSequence() {
		return fileSequence;
	}

	public void setFileSequence(int fileSequence) {
		this.fileSequence = fileSequence;
	}

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
		return "FileVo [qnaSequence=" + qnaSequence + ", fileSequence="
				+ fileSequence + ", fileName=" + fileName + ", fileCode="
				+ fileCode + "]";
	}
	
}

package org.redborn.csatlatte.domain;

public class QnaFileVo {

	private int qnaSequence;
	private int fileSequence;
	private String fileCode;
	private String fileName;
	
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
	
	public String getFileCode() {
		return fileCode;
	}
	
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		return "QnaFileVo [qnaSequence=" + qnaSequence + ", fileSequence="
				+ fileSequence + ", fileCode=" + fileCode + ", fileName="
				+ fileName + "]";
	}
	
}

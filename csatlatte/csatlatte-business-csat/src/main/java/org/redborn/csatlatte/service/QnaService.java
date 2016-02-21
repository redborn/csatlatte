package org.redborn.csatlatte.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.redborn.csatlatte.domain.FileVo;
import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaForStudentVo;
import org.redborn.csatlatte.domain.QnaVo;

public interface QnaService {

	public QnaVo detail(int qnaSequence);
	public List<QnaForManageVo> listForManage(String search, int pageNumber, int countQnaAnswer);
	public List<QnaForStudentVo> listForStudent(int studentSequence);
	public List<FileVo> fileList(int qnaSequence);
	public boolean delete(int qnaSequence);
	public boolean write(QnaVo qnaVo, List<File> files);
	public boolean answer(QnaAnswerVo qnaAnswerVo);
	public int amountQuestion(String search, int countQnaAnswer);
	public int getWriter(int qnaSequence);
	public String getFilename(int qnaSequence, int fileSequence);
	public InputStream getInputStream(int qnaSequence, int fileSequence);
	
}

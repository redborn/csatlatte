package org.redborn.csatlatte.service;

import java.io.File;
import java.util.List;

import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaForStudentVo;
import org.redborn.csatlatte.domain.QnaVo;

public interface QnaService {

	public QnaVo detail(int qnaSequence);
	public QnaVo detailForStudent (int studentSequence, int qnaSequence);
	public List<QnaForManageVo> listForManage(String search, int pageNumber, int countQnaAnswer);
	public List<QnaForStudentVo> listForStudent(int studentSequence);
	public boolean delete(int qnaSequence);
	public boolean write(QnaVo qnaVo, List<File> listFile);
	public boolean answer(QnaAnswerVo qnaAnswerVo);
	public int amountQuestion(String search, int countQnaAnswer);
	
}

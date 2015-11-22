package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.redborn.csatlatte.domain.QnaContentVo;
import org.redborn.csatlatte.domain.QnaDetailVo;
import org.redborn.csatlatte.domain.QnaFileVo;
import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaForStudentVo;
import org.redborn.csatlatte.domain.QnaVo;

public interface QnaService {

	public QnaDetailVo detail(int qnaSequence);
	public List<QnaForManageVo> list(String search, int pageNumber);
	public List<QnaForStudentVo> list(int studentSequence, int pageNumber);
	public boolean delete(int qnaSequence);
	public boolean write(QnaVo qnaVo, QnaContentVo qnaContentVo, QnaFileVo qnaFileVo);
	public boolean answer(QnaAnswerVo qnaAnswerVo);
	
}

package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.redborn.csatlatte.domain.QnaFileVo;
import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaForStudentVo;
import org.redborn.csatlatte.domain.QnaVo;
import org.redborn.csatlatte.persistence.QnaDao;
import org.redborn.csatlatte.persistence.qna.AnswerDao;
import org.redborn.csatlatte.persistence.qna.ContentDao;
import org.redborn.csatlatte.persistence.qna.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDao qnaDao;
	@Autowired
	private ContentDao contentDao;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private AnswerDao answerDao;
	
	public QnaVo detail(int qnaSequence) {
		QnaVo qnaVo = new QnaVo();
		
		List<String> contentList = contentDao.selectList(qnaSequence);
		String content = null;
		
		if (contentList != null) {
			int contentSize = contentList.size();
			for (int index = 0; index < contentSize; index++) {
					content += contentList.get(index);
			}
		}
		
		qnaVo.setContent(content);
		qnaVo.setWriteDate(qnaDao.selectOne(qnaSequence));
		qnaVo.setFile(fileDao.selectList(qnaSequence));
		
		return qnaVo;
	}

	public List<QnaForManageVo> list(String search, int pageNumber) {
		return qnaDao.selectListForManage(search, pageNumber);
	}

	public List<QnaForStudentVo> list(int studentSequence, int pageNumber) {
		return qnaDao.selectListForStudent(studentSequence, pageNumber);
	}

	public boolean delete(int qnaSequence) {
		return qnaDao.updateUseYnN(qnaSequence) == 1;
	}

	public boolean write(QnaVo qnaVo, QnaFileVo qnaFileVo) {
		boolean result = false;
		int maxQnaSequence = qnaDao.selectOneMaxQnaSequence();
		qnaVo.setQnaSequence(maxQnaSequence);
		qnaFileVo.setQnaSequence(maxQnaSequence);
		
		if(qnaDao.insert(maxQnaSequence, qnaVo.getStudentSequence()) == 1
				&& contentDao.insert(qnaVo.getQnaSequence(), qnaVo.getContent()) == 1
				&& fileDao.insert(qnaFileVo) == 1) {
			result = true;
		}
		
		return result;
	}

	public boolean answer(QnaAnswerVo qnaAnswerVo) {
		return answerDao.insert(qnaAnswerVo) == 1;
	}

}

package org.redborn.csatlatte.service;

import java.io.File;
import java.util.List;

import org.redborn.csatlatte.domain.FileVo;
import org.redborn.csatlatte.domain.QnaAnswerVo;
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
		qnaVo.setTitle(qnaDao.selectOne(qnaSequence).getTitle());
		qnaVo.setWriteDate(qnaDao.selectOne(qnaSequence).getWriteDate());
		qnaVo.setFile(fileDao.selectList(qnaSequence));
		
		return qnaVo;
	}

	public List<QnaForManageVo> listForManage(String search, int pageNumber) {
		return qnaDao.selectListForManage(search, pageNumber);
	}

	public List<QnaForStudentVo> listForStudent(int studentSequence, int pageNumber) {
		return qnaDao.selectListForStudent(studentSequence, pageNumber);
	}

	public boolean delete(int qnaSequence) {
		return qnaDao.updateUseYnN(qnaSequence) == 1;
	}

	public boolean write(QnaVo qnaVo, List<File> listFile) {
		boolean result = false;
		
		int maxQnaSequence = qnaDao.selectOneMaxQnaSequence();
		
		String content = qnaVo.getContent();
		int max = content.length() / 2000;
		int beginIndex;
		
		int listFileSize = listFile.size();
		FileVo fileVo = new FileVo();
		
		qnaVo.setQnaSequence(maxQnaSequence);
		
		if ((content.length() % 2000) != 0) {
			max++;
		}
		
		for (int index = 0; index < max; index++) {
			beginIndex = 2000 * index; 
			qnaVo.setContent(content.substring(beginIndex, beginIndex + 2000));
			contentDao.insert(qnaVo.getQnaSequence(), qnaVo.getContent());
		}
		
		for (int index = 0; index < listFileSize; index++) {
			// fileVo = listFile.get(index);
			
			// file처리에 대한 교육을 마친 후 진행해야 함
			// List<File>을 fileVo로 담는 방법을 모름
			fileDao.insert(maxQnaSequence, fileVo);
		}
		
		if(qnaDao.insert(maxQnaSequence, qnaVo.getStudentSequence()) == 1) {
			result = true;
		}
		
		return result;
	}

	public boolean answer(QnaAnswerVo qnaAnswerVo) {
		return answerDao.insert(qnaAnswerVo) == 1;
	}

}

package org.redborn.csatlatte.service;

import java.io.File;
import java.util.List;

import org.redborn.csatlatte.commons.amazonaws.services.s3.CsatAmazonS3;
import org.redborn.csatlatte.commons.amazonaws.services.s3.CsatAmazonS3Prefix;
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
	@Autowired
	private CsatAmazonS3 csatAmazonS3;
	
	public QnaVo detail(int qnaSequence) {
		QnaVo qnaVo = qnaDao.selectOne(qnaSequence);
		List<String> answerContentList = answerDao.selectList(qnaSequence);
		
		if (qnaVo != null) {
			List<String> contentList = contentDao.selectList(qnaSequence);
			String content = "";
			if (contentList != null) {
				int contentSize = contentList.size();
				for (int index = 0; index < contentSize; index++) {
					content += contentList.get(index);
				}
			}
			qnaVo.setContent(content);
			qnaVo.setFile(fileDao.selectList(qnaSequence));
			
			if (answerContentList != null) {
				String answerContent = "";
				int answerContentSize = answerContentList.size();
				for (int index = 0; index < answerContentSize; index++) {
					answerContent += answerContentList.get(index);
				}
				qnaVo.setAnswerContent(answerContent);
			}
		}
	
		return qnaVo;
	}
	
	public List<QnaForManageVo> listForManage(String search, int pageNumber, int countQnaAnswer) {
		return qnaDao.selectListForManage(search, pageNumber, countQnaAnswer);
	}

	public List<QnaForStudentVo> listForStudent(int studentSequence) {
		return qnaDao.selectListForStudent(studentSequence);
	}

	public boolean delete(int qnaSequence) {
		return qnaDao.updateUseYnN(qnaSequence) == 1;
	}

	public boolean write(QnaVo qnaVo, List<File> files) {
		boolean result = true;
		
		int maxQnaSequence = qnaDao.selectOneMaxQnaSequence();
		
		String content = qnaVo.getContent();
		int max = content.length() / 2000;
		int beginIndex = 0;
		
		if (qnaDao.insert(maxQnaSequence, qnaVo.getStudentSequence(), qnaVo.getTitle()) != 1) {
			result = false;
		}
		
		for (int index = 0; index < max; index++) {
			beginIndex = 2000 * index; 
			if (contentDao.insert(maxQnaSequence, content.substring(beginIndex, beginIndex + 2000)) != 1) {
				result = false;
			}
		}
		
		if (content.length() % 2000 != 0) {
			if (contentDao.insert(maxQnaSequence, content.substring(max * 2000, content.length())) != 1) {
				result = false;
			}
		}
		
		FileVo fileVo = new FileVo();
		if (files != null) {
			int fileSize = files.size();
			for (int index = 0; index < fileSize; index++) {
				if (files.get(index) != null) {
					File file = files.get(index);
					fileVo.setFileName(file.getName());
					fileVo.setFileCode(csatAmazonS3.upload(file, CsatAmazonS3Prefix.QNA));
					file.delete();
					if (fileDao.insert(maxQnaSequence, fileVo) != 1) {
						result = false;
					}
				}
			}
		}
		
		return result;
	}

	public boolean answer(QnaAnswerVo qnaAnswerVo) {
		return answerDao.insert(qnaAnswerVo) == 1;
	}
	
	public int amountQuestion(String search, int countQnaAnswer) {
		return qnaDao.selectOneCount(search, countQnaAnswer);
	}

}

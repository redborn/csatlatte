package org.redborn.csatlatte.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.redborn.csatlatte.commons.amazonaws.services.s3.CsatAmazonS3;
import org.redborn.csatlatte.commons.amazonaws.services.s3.CsatAmazonS3Prefix;
import org.redborn.csatlatte.domain.FileVo;
import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaVo;
import org.redborn.csatlatte.persistence.QnaDao;
import org.redborn.csatlatte.persistence.qna.AnswerDao;
import org.redborn.csatlatte.persistence.qna.ContentDao;
import org.redborn.csatlatte.persistence.qna.FileDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class QnaServiceImpl implements QnaService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private QnaDao qnaDao;
	@Autowired
	private ContentDao contentDao;
	@Autowired
	private FileDao fileDao;
	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private PlatformTransactionManager transactionManager;
	@Autowired
	private CsatAmazonS3 csatAmazonS3;
	
	public QnaVo detail(int qnaSequence) {
		logger.info("Business layer qna detail.");
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
		logger.info("Business layer qna listForManage.");
		return qnaDao.selectListForManage(search, pageNumber, countQnaAnswer);
	}

	public List<QnaVo> listForStudent(int studentSequence) {
		logger.info("Business layer qna listForStudent.");
		return qnaDao.selectListForStudent(studentSequence);
	}
	
	public List<FileVo> fileList(int qnaSequence) {
		logger.info("Business layer qna fileList.");
		return fileDao.selectListForDetail(qnaSequence);
	}

	public boolean delete(int qnaSequence) {
		logger.info("Business layer qna delete.");
		return qnaDao.updateUseYnN(qnaSequence) == 1;
	}

	public boolean write(QnaVo qnaVo, List<File> files, String userAgent, String sessionId, String ip) {
		logger.info("Business layer qna write.");
		int maxQnaSequence = qnaDao.selectOneMaxQnaSequence();
		
		String content = qnaVo.getContent();
		int max = content.length() / 2000;
		int beginIndex = 0;
		
		boolean result = false;
		
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("qna write transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		try {
			if (qnaDao.insert(maxQnaSequence, qnaVo.getStudentSequence(), qnaVo.getTitle(), userAgent, sessionId, ip) == 1) {
				result = true;
				for (int index = 0; index < max; index++) {
					beginIndex = 2000 * index; 
					if (contentDao.insert(maxQnaSequence, content.substring(beginIndex, beginIndex + 2000)) != 1) {
						result = false;
						break;
					}
				}
				if (result && content.length() % 2000 != 0) {
					if (contentDao.insert(maxQnaSequence, content.substring(max * 2000, content.length())) != 1) {
						result = false;
					}
				}
			}
			
			if (result) {
				FileVo fileVo = new FileVo();
				if (files != null) {
					int fileSize = files.size();
					for (int index = 0; index < fileSize; index++) {
						File file = files.get(index);
						if (file != null) {
							fileVo.setFileName(file.getName());
							fileVo.setFileCode(csatAmazonS3.upload(file, CsatAmazonS3Prefix.QNA));
							file.delete();
							if (fileDao.insert(maxQnaSequence, fileVo) != 1) {
								result = false;
								break;
							}
						}
					}
				}
			}
			if (result) {
				transactionManager.commit(transactionStatus);
				logger.info(new StringBuilder("Business layer qna write success. Transaction commit. Writer is ").append(qnaVo.getStudentSequence()).toString());
			} else {
				transactionManager.rollback(transactionStatus);
				logger.warn(new StringBuilder("Business layer qna write fail. Transaction rollback. Writer is ").append(qnaVo.getStudentSequence()).toString());
			}
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);
			logger.warn(new StringBuilder("Business layer qna write exception. Transaction rollback. Writer is ").append(qnaVo.getStudentSequence()).toString());
		}
		
		return result;
	}

	public boolean answer(QnaAnswerVo qnaAnswerVo) {
		logger.info("Business layer qna answer.");
		return answerDao.insert(qnaAnswerVo) == 1;
	}
	
	public int amountQuestion(String search, int countQnaAnswer) {
		logger.info("Business layer qna amountQuestion.");
		return qnaDao.selectOneCount(search, countQnaAnswer);
	}

	public String getFilename(int qnaSequence, int fileSequence) {
		logger.info("Business layer qna getFilename.");
		return fileDao.selectFileName(qnaSequence, fileSequence);
	}
	
	public InputStream getInputStream(int qnaSequence, int fileSequence) {
		logger.info("Business layer qna getInputStream.");
		return csatAmazonS3.getInputStream(CsatAmazonS3Prefix.QNA, fileDao.selectFileCode(qnaSequence, fileSequence));
	}

	public int getWriter(int qnaSequence) {
		logger.info("Business layer qna getWriter.");
		QnaVo qnaVo = qnaDao.selectOne(qnaSequence);
		return qnaVo != null ? qnaVo.getStudentSequence() : -1;
	}

}

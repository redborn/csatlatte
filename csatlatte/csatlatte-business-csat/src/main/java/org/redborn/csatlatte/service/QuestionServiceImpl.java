package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.QuestionVo;
import org.redborn.csatlatte.persistence.QuestionDao;
import org.redborn.csatlatte.persistence.question.ObjectItemDao;
import org.redborn.csatlatte.persistence.question.TextDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private ObjectItemDao objectItemDao;
	@Autowired
	private TextDao textDao;
	@Autowired
	private org.redborn.csatlatte.persistence.question.objectquestion.CorrectAnswerDao objectCorrectAnswerDao;
	@Autowired
	private org.redborn.csatlatte.persistence.question.subjectquestion.CorrectAnswerDao subjectCorrectAnswerDao;
	@Autowired
	private PlatformTransactionManager transactionManager;

	public List<QuestionVo> list(int csatSequence, int examSequence) {
		logger.info("Business layer question list.");
		
		return questionDao.selectList(csatSequence, examSequence);
	}
	
	public boolean delete(int csatSequence, int examSequence) {
		logger.info("Business layer question delete.");
		boolean result = false;
		
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("ratingCut delete transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		try {
			objectCorrectAnswerDao.delete(csatSequence, examSequence);
			subjectCorrectAnswerDao.delete(csatSequence, examSequence);
			textDao.delete(csatSequence, examSequence);
			objectItemDao.delete(csatSequence, examSequence);
			questionDao.delete(csatSequence, examSequence);
			transactionManager.commit(transactionStatus);
			result = true;
			logger.info(new StringBuilder("Business layer question delete success. transaction rollback. CsatSequence is ").append(csatSequence).append(". ExamSequence is ").append(examSequence).append(".").toString());
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);
			logger.warn(new StringBuilder("Business layer question delete exception. Transaction rollback. CsatSequence is ").append(csatSequence).append(". ExamSequence is ").append(examSequence).append(".").toString());
		}
		
		return result;
	}

}

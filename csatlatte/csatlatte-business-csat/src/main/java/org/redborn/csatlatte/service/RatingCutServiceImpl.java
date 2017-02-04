package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.redborn.csatlatte.persistence.QuestionDao;
import org.redborn.csatlatte.persistence.exam.AverageDao;
import org.redborn.csatlatte.persistence.exam.RatingCutDao;
import org.redborn.csatlatte.persistence.exam.SectionDao;
import org.redborn.csatlatte.persistence.exam.SubjectDao;
import org.redborn.csatlatte.persistence.exam.student.ScoreDao;
import org.redborn.csatlatte.persistence.exam.subject.ListeningDao;
import org.redborn.csatlatte.persistence.question.ImageDao;
import org.redborn.csatlatte.persistence.question.ObjectiveItemDao;
import org.redborn.csatlatte.persistence.question.TextDao;
import org.redborn.csatlatte.persistence.question.object.CorrectAnswerDao;
import org.redborn.csatlatte.persistence.question.text.ContentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class RatingCutServiceImpl implements RatingCutService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AverageDao averageDao;
	@Autowired
	private RatingCutDao ratingCutDao;
	@Autowired
	private SectionDao sectionDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private ScoreDao scoreDao;
	@Autowired
	private CorrectAnswerDao correctAnswerDao;
	@Autowired
	private ImageDao imageDao;
	@Autowired
	private ContentDao contentDao;
	@Autowired
	private TextDao textDao;
	@Autowired
	private org.redborn.csatlatte.persistence.question.object.ImageDao objectiveItemImageDao;
	@Autowired
	private ObjectiveItemDao objectiveItemDao;
	@Autowired
	private org.redborn.csatlatte.persistence.question.text.ImageDao textImageDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private ListeningDao listeningDao;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public List<RatingCutVo> list(int csatSequence, int examSequence) {
		logger.info("Business layer ratingcut list.");
		return ratingCutDao.selectListDetail(csatSequence, examSequence);
	}
	
	public List<ExamVo> listForRatingManage(int csatSequence) {
		logger.info("Business layer ratingcut listForRatingManage.");
		return ratingCutDao.selectList(csatSequence);
	}
	
	public List<ExamVo> listForRatingCreate(int csatSequence) {
		logger.info("Business layer ratingcut listForRatingCreate.");
		return ratingCutDao.selectListForCreate(csatSequence);
	}
	
	public boolean delete(int csatSequence, int examSequence) {
		logger.info("Business layer ratingcut delete.");
		boolean result = false;
		boolean isQuestion = questionDao.selectOneCount(csatSequence, examSequence, null, null) > 0;
		logger.info("test : " + isQuestion);
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("ratingCut delete transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		try {
			if (isQuestion) {
				listeningDao.delete(csatSequence, examSequence);
				correctAnswerDao.delete(csatSequence, examSequence, null, null);
				textImageDao.delete(csatSequence, examSequence, null, null);
				contentDao.delete(csatSequence, examSequence, null, null);
				textDao.delete(csatSequence, examSequence, null, null);
				objectiveItemImageDao.delete(csatSequence, examSequence, null, null);
				objectiveItemDao.delete(csatSequence, examSequence, null, null);
				imageDao.delete(csatSequence, examSequence, null, null);
				questionDao.delete(csatSequence, examSequence, null, null);
			}
			scoreDao.deleteForManage(csatSequence, examSequence);
			ratingCutDao.delete(csatSequence, examSequence, null, null);
			averageDao.delete(csatSequence, examSequence, null, null);
			subjectDao.delete(csatSequence, examSequence, null, null);
			sectionDao.delete(csatSequence, examSequence, null, null);
			transactionManager.commit(transactionStatus);
			result = true;
			logger.info(new StringBuilder("Business layer ratingCut delete success. transaction rollback. CsatSequence is ").append(csatSequence).append(". ExamSequence is ").append(examSequence).append(".").toString());
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);
			logger.warn(new StringBuilder("Business layer RatingCut delete exception. Transaction rollback. CsatSequence is ").append(csatSequence).append(". ExamSequence is ").append(examSequence).append(".").toString());
		}
		
		return result;
	}

	public boolean register(List<SectionVo> sectionList, List<SubjectVo> subjectList, List<RatingCutVo> ratingCutList, List<AverageVo> averageList) {
		logger.info("Business layer ratingcut register.");
		boolean result = false;
		
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("ratingCut register transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		try {
			if (sectionList != null) {
				int sectionListSize = sectionList.size();
				for (int index = 0; index < sectionListSize; index++) {
					sectionDao.insert(sectionList.get(index));
				}
			}
				
			if (subjectList != null) {
				int subjectListSize = subjectList.size();
				for (int index = 0; index < subjectListSize; index++) {
					subjectDao.insert(subjectList.get(index));
				}
			}
				
			if (ratingCutList != null) {
				int ratingCutListSize = ratingCutList.size();
				for (int index = 0; index < ratingCutListSize; index++) {
					ratingCutDao.insert(ratingCutList.get(index));
				}
			}
			
			if (averageList != null) {
				int averageListSize = averageList.size();
				for (int index = 0; index < averageListSize; index++) {
					averageDao.insert(averageList.get(index));
				}
			}
			transactionManager.commit(transactionStatus);
			result = true;
			logger.info(new StringBuilder("Business layer RatingCut register success. transaction rollback.").toString());
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);
			logger.warn(new StringBuilder("Business layer RatingCut register exception. Transaction rollback.").toString());
		}
		return result;
	}
	
	public boolean modify(List<SectionVo> sectionList, List<SubjectVo> subjectList, List<RatingCutVo> ratingCutList, List<AverageVo> averageList) {
		logger.info("Business layer ratingcut modify.");
		boolean result = false;
		
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("ratingCut modify transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		try {
			if (sectionList != null) {
				int sectionListSize = sectionList.size();
				for (int index = 0; index < sectionListSize; index++) {
					SectionVo sectionVo = sectionList.get(index);
					if (sectionDao.update(sectionVo) != 1) {
						sectionDao.insert(sectionVo);
					}
				}
			}
				
			if (subjectList != null) {
				int subjectListSize = subjectList.size();
				for (int index = 0; index < subjectListSize; index++) {
					SubjectVo subjectVo = subjectList.get(index);
					if (subjectDao.update(subjectVo) != 1) {
						subjectDao.insert(subjectVo);
					}
				}
			}
				
			if (ratingCutList != null) {
				int ratingCutListSize = ratingCutList.size();
				for (int index = 0; index < ratingCutListSize; index++) {
					RatingCutVo ratingCutVo = ratingCutList.get(index);
					if (ratingCutDao.update(ratingCutVo) != 1) {
						ratingCutDao.insert(ratingCutVo);
					}
				}
			}
			
			if (averageList != null) {
				int averageListSize = averageList.size();
				for (int index = 0; index < averageListSize; index++) {
					AverageVo averageVo = averageList.get(index);
					if (averageDao.update(averageVo) != 1) {
						averageDao.insert(averageVo);
					}
				}
			}
			
			averageDao.deleteForModifyRatingCut(averageList);
			ratingCutDao.deleteForModifyRatingCut(ratingCutList);
			
			scoreDao.deleteForModifyRatingCutBySubject(subjectList);
			listeningDao.deleteForModifyRatingCutBySubject(subjectList);
			correctAnswerDao.deleteForModifyRatingCutBySubject(subjectList);
			textImageDao.deleteForModifyRatingCutBySubject(subjectList);
			contentDao.deleteForModifyRatingCutBySubject(subjectList);
			textDao.deleteForModifyRatingCutBySubject(subjectList);
			objectiveItemImageDao.deleteForModifyRatingCutBySubject(subjectList);
			objectiveItemDao.deleteForModifyRatingCutBySubject(subjectList);
			imageDao.deleteForModifyRatingCutBySubject(subjectList);
			questionDao.deleteForModifyRatingCutBySubject(subjectList);
			averageDao.deleteForModifyRatingCutBySubject(subjectList);
			ratingCutDao.deleteForModifyRatingCutBySubject(subjectList);
			subjectDao.deleteForModifyRatingCutBySubject(subjectList);
			
			sectionDao.deleteForModifyRatingCut(sectionList);
			
			transactionManager.commit(transactionStatus);
			result = true;
			logger.info(new StringBuilder("Business layer ratingCut modify success. transaction rollback.").toString());
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);
			logger.warn(new StringBuilder("Business layer ratingCut modify exception. transaction rollback.").toString());
		}
		
		return result;
	}

}

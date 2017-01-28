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
		boolean sectionSuccess = false;
		boolean subjectSuccess = false;
		boolean ratingCutSuccess = false;
		
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
				sectionSuccess = true;
			}
				
			if (subjectList != null && sectionSuccess) {
				int subjectListSize = subjectList.size();
				for (int index = 0; index < subjectListSize; index++) {
					subjectDao.insert(subjectList.get(index));
				}
				subjectSuccess = true;
			}
				
			if (ratingCutList != null && sectionSuccess && subjectSuccess) {
				int ratingCutListSize = ratingCutList.size();
				for (int index = 0; index < ratingCutListSize; index++) {
					ratingCutDao.insert(ratingCutList.get(index));
				}
				ratingCutSuccess = true;
			}
			
			if (averageList != null && sectionSuccess && subjectSuccess && ratingCutSuccess) {
				int averageListSize = averageList.size();
				for (int index = 0; index < averageListSize; index++) {
					averageDao.insert(averageList.get(index));
				}
				result = true;
			}
			transactionManager.commit(transactionStatus);
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
		boolean sectionSuccess = false;
		boolean subjectSuccess = false;
		boolean ratingCutSuccess = false;
		
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("ratingCut modify transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		try {
			if (sectionList != null) {
				int sectionListSize = sectionList.size();
				for (int index = 0; index < sectionListSize; index++) {
					SectionVo sectionVo = sectionList.get(index);
					if (sectionDao.selectOneCount(sectionVo) == 1) {
						sectionDao.update(sectionVo);
					} else {
						sectionDao.insert(sectionVo);
					}
				}
				sectionSuccess = true;
				logger.info("asdasd : " + sectionSuccess);
			}
				
			if (subjectList != null && sectionSuccess) {
				int subjectListSize = subjectList.size();
				for (int index = 0; index < subjectListSize; index++) {
					SubjectVo subjectVo = subjectList.get(index);
					if (subjectDao.selectOneCount(subjectVo) == 1) {
						subjectDao.update(subjectVo);
					} else {
						subjectDao.insert(subjectVo);
					}
				}
				subjectSuccess = true;
				logger.info("asdasd2 : " + subjectSuccess);
			}
				
			if (ratingCutList != null && sectionSuccess && subjectSuccess) {
				int ratingCutListSize = ratingCutList.size();
				for (int index = 0; index < ratingCutListSize; index++) {
					RatingCutVo ratingCutVo = ratingCutList.get(index);
					if (ratingCutDao.selectOneCount(ratingCutVo) == 1) {
						ratingCutDao.update(ratingCutVo);
					} else {
						ratingCutDao.insert(ratingCutVo);
					}
				}
				ratingCutSuccess = true;
				logger.info("asdasd3 : " + ratingCutSuccess);
			}
			
			if (averageList != null && sectionSuccess && subjectSuccess && ratingCutSuccess) {
				int averageListSize = averageList.size();
				for (int index = 0; index < averageListSize; index++) {
					AverageVo averageVo = averageList.get(index);
					if (averageDao.selectOneCount(averageVo) == 1) {
						averageDao.update(averageVo);
					} else {
						averageDao.insert(averageVo);
					}
				}
				logger.info("asdasd4 : " + result);
			}
			
			List<AverageVo> deleteAverageList = averageDao.selectListForModifyRatingCut(averageList);
			if (deleteAverageList != null) {
				int deleteAverageListSize = deleteAverageList.size();
				for (int index = 0; index < deleteAverageListSize; index++) {
					averageDao.delete(deleteAverageList.get(index).getCsatSequence(), deleteAverageList.get(index).getExamSequence(), deleteAverageList.get(index).getSectionSequence(), deleteAverageList.get(index).getSubjectSequence());
				}
			}
			
			List<RatingCutVo> deleteRatingCutList = ratingCutDao.selectListForModifyRatingCut(ratingCutList);
			if (deleteRatingCutList != null) {
				int deleteRatingCutListSize = deleteRatingCutList.size();
				for (int index = 0; index < deleteRatingCutListSize; index++) {
					ratingCutDao.delete(deleteRatingCutList.get(index).getCsatSequence(), deleteRatingCutList.get(index).getExamSequence(), deleteRatingCutList.get(index).getSectionSequence(), deleteRatingCutList.get(index).getSubjectSequence());
				}
			}
			
			List<SubjectVo> deleteSubjectList = subjectDao.selectListForModifyRatingCut(subjectList);
			if (deleteSubjectList != null) {
				int deleteSubjectListSize = deleteSubjectList.size();
				for (int index = 0; index < deleteSubjectListSize; index++) {
					int csatSequence = deleteSubjectList.get(index).getCsatSequence();
					int examSequence = deleteSubjectList.get(index).getExamSequence();
					int sectionSequence = deleteSubjectList.get(index).getSectionSequence();
					int subjectSequence = deleteSubjectList.get(index).getSubjectSequence();
					if (questionDao.selectOneCount(csatSequence, examSequence, sectionSequence, subjectSequence) > 0) {
						correctAnswerDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
						textImageDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
						contentDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
						textDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
						objectiveItemImageDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
						objectiveItemDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
						imageDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
						questionDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
					}
					averageDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
					ratingCutDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
					subjectDao.delete(csatSequence, examSequence, sectionSequence, subjectSequence);
				}
			}
			
			List<SectionVo> deleteSectionList = sectionDao.selectListForModifyRatingCut(sectionList);
			if (deleteSectionList != null) {
				int deleteSectionListSize = deleteSectionList.size();
				for (int index = 0; index < deleteSectionListSize; index++) {
					int csatSequence = deleteSectionList.get(index).getCsatSequence();
					int examSequence = deleteSectionList.get(index).getExamSequence();
					int sectionSequence = deleteSectionList.get(index).getSectionSequence();
					if (questionDao.selectOneCount(csatSequence, examSequence, sectionSequence, null) > 0) {
						correctAnswerDao.delete(csatSequence, examSequence, sectionSequence, null);
						textImageDao.delete(csatSequence, examSequence, sectionSequence, null);
						contentDao.delete(csatSequence, examSequence, sectionSequence, null);
						textDao.delete(csatSequence, examSequence, sectionSequence, null);
						objectiveItemImageDao.delete(csatSequence, examSequence, sectionSequence, null);
						objectiveItemDao.delete(csatSequence, examSequence, sectionSequence, null);
						imageDao.delete(csatSequence, examSequence, sectionSequence, null);
						questionDao.delete(csatSequence, examSequence, sectionSequence, null);
					}
					averageDao.delete(csatSequence, examSequence, sectionSequence, null);
					ratingCutDao.delete(csatSequence, examSequence, sectionSequence, null);
					subjectDao.delete(csatSequence, examSequence, sectionSequence, null);
					sectionDao.delete(csatSequence, examSequence, sectionSequence, null);
				}
			}
		
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

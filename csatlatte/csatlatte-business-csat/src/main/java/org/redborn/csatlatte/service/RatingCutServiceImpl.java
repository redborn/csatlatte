package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.redborn.csatlatte.persistence.exam.AverageDao;
import org.redborn.csatlatte.persistence.exam.RatingCutDao;
import org.redborn.csatlatte.persistence.exam.SectionDao;
import org.redborn.csatlatte.persistence.exam.SubjectDao;
import org.redborn.csatlatte.persistence.exam.student.ScoreDao;
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
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("ratingCut delete transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		try {
			scoreDao.deleteForManage(csatSequence, examSequence);
			ratingCutDao.delete(csatSequence, examSequence);
			averageDao.delete(csatSequence, examSequence);
			subjectDao.delete(csatSequence, examSequence);
			sectionDao.delete(csatSequence, examSequence);
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
		
		return result;
	}

}

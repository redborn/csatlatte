package org.redborn.csatlatte.service;

import java.util.ArrayList;
import java.util.List;

import org.redborn.csatlatte.domain.AverageVo;
import org.redborn.csatlatte.domain.CorrectAnswerVo;
import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.GradeVo;
import org.redborn.csatlatte.domain.InstitutionVo;
import org.redborn.csatlatte.domain.QuestionVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SectionVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.redborn.csatlatte.domain.TextVo;
import org.redborn.csatlatte.persistence.CsatDao;
import org.redborn.csatlatte.persistence.ExamDao;
import org.redborn.csatlatte.persistence.InstitutionDao;
import org.redborn.csatlatte.persistence.QuestionDao;
import org.redborn.csatlatte.persistence.exam.AverageDao;
import org.redborn.csatlatte.persistence.exam.RatingCutDao;
import org.redborn.csatlatte.persistence.exam.SectionDao;
import org.redborn.csatlatte.persistence.exam.SubjectDao;
import org.redborn.csatlatte.persistence.exam.student.ScoreDao;
import org.redborn.csatlatte.persistence.question.TextDao;
import org.redborn.csatlatte.persistence.question.object.CorrectAnswerDao;
import org.redborn.csatlatte.persistence.question.text.ContentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExamDao examDao;
	@Autowired
	private CsatDao csatDao;
	@Autowired
	private InstitutionDao institutionDao;
	@Autowired
	private RatingCutDao ratingCutDao;
	@Autowired
	private AverageDao averageDao;
	@Autowired
	private SectionDao sectionDao;
	@Autowired
	private SubjectDao subjectDao;
	@Autowired
	private ScoreDao scoreDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private CorrectAnswerDao correctAnswerDao;
	@Autowired
	private TextDao textDao;
	@Autowired
	private ContentDao contentDao;

	public CsatVo getCsat(int csatSequence) {
		logger.info("Business layer exam getCsat.");
		return csatDao.selectOne(csatSequence);
	}

	public int getExamTime(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence) {
		logger.info("Business layer exam getExamTime.");
		return subjectDao.selectExamTime(csatSequence, examSequence, sectionSequence, subjectSequence);
	}

	public String getName(int csatSequence, int examSequence) {
		logger.info("Business layer exam getName.");
		return examDao.selectExamName(csatSequence, examSequence);
	}

	public String getSubjectName(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence) {
		logger.info("Business layer exam getSubjectName.");
		return subjectDao.selectSubjectName(csatSequence, examSequence, sectionSequence, subjectSequence);
	}
	
	public List<CsatVo> csatList() {
		logger.info("Business layer exam csatList.");
		return csatDao.selectListYear();
	}
	
	public List<String> yearListForRating(int yearStudentSequence) {
		logger.info("Business layer exam yearListForRating.");
		return examDao.selectListYearForRating(yearStudentSequence);
	}

	public List<String> yearListForSolving(int yearStudentSequence) {
		logger.info("Business layer exam yearListForSolving.");
		return examDao.selectListYearForSolving(yearStudentSequence);
	}
	
	public List<ExamVo> listForRating(String year, int yearStudentSequence) {
		logger.info("Business layer exam listForRating.");
		return examDao.selectListExamForRating(year, yearStudentSequence);
	}

	public List<ExamVo> listForSolving(String year, int yearStudentSequence) {
		logger.info("Business layer exam listForSolving.");
		return examDao.selectListExamForSolving(year, yearStudentSequence);
	}
	
	public List<ExamVo> listForManage(int csatSequence) {
		logger.info("Business layer exam listForManage");
		return examDao.selectListExamForManage(csatSequence);
	}
	
	public List<AverageVo> averageList(int csatSequence, int examSequence) {
		logger.info("Business layer exam averageList");
		return averageDao.selectList(csatSequence, examSequence);
	}
	
	public List<SectionVo> sectionList(int csatSequence, int examSequence) {
		logger.info("Business layer exam sectionList.");
		return sectionDao.selectList(csatSequence, examSequence);
	}
	
	public List<SubjectVo> subjectList(int csatSequence, int examSequence) {
		logger.info("Business layer exam subjectList.");
		return subjectDao.selectList(csatSequence, examSequence);
	}

	public List<SubjectVo> subjectListForSolving(int csatSequence,
			int examSequence) {
		logger.info("Business layer exam subjectListForSolving.");
		return subjectDao.selectListForSolving(csatSequence, examSequence);
	}

	public boolean register(ExamVo examVo) {
		logger.info("Business layer exam register.");
		examVo.setExamSequence(examDao.selectOneCountMax(examVo.getCsatSequence()));
		return examDao.insert(examVo) == 1;
	}

	public boolean modify(ExamVo examVo) {
		logger.info("Business layer exam modify.");
		return examDao.update(examVo) == 1;
	}

	public boolean delete(int csatSequence, int examSequence) {
		logger.info("Business layer exam delete.");
		return examDao.delete(csatSequence, examSequence) == 1;
	}
	
	public List<InstitutionVo> institutionList() {
		logger.info("Business layer exam institutionList.");
		return institutionDao.selectList();
	}

	public List<QuestionVo> questionList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		logger.info("Business layer exam questionList.");
		return questionDao.selectList(csatSequence, examSequence, sectionSequence, subjectSequence);
	}
	
	public List<ExamVo> detail(int csatSequence, int examSequence) {
		logger.info("Business layer exam detail.");
		return examDao.selectListDetailForManage(csatSequence, examSequence);
	}
	
	public List<ExamVo> listForRatingManage(int csatSequence) {
		logger.info("Business layer exam listForRatingManage.");
		return ratingCutDao.selectList(csatSequence);
	}
	
	public List<ExamVo> listForRatingCreate(int csatSequence) {
		logger.info("Business layer exam listForRatingCreate.");
		return ratingCutDao.selectListForCreate(csatSequence);
	}
	
	public List<GradeVo> examStudentList(int csatSequence, int examSequence) {
		logger.info("Business layer exam examStudentList.");
		return scoreDao.selectListExamStudent(csatSequence, examSequence);
	}

	public List<Boolean> marking(List<Integer> questionNumber, int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		logger.info("Business layer exam calculateScore.");
		List<CorrectAnswerVo> answerList = correctAnswerDao.selectList(csatSequence, examSequence, sectionSequence, subjectSequence);
		List<Boolean> resultMarking = new ArrayList<Boolean>();
		if (questionNumber != null) {
			int questionNumberSize = questionNumber.size();
			int answerListSize = answerList.size();
			if (questionNumberSize == answerListSize) {
				for (int index = 0; index < questionNumberSize; index++) {
					if (questionNumber.get(index) == answerList.get(index).getObjectItemSequence()) {
						resultMarking.add(true);
					} else {
						resultMarking.add(false);
					}
				}
			}
		}
		return resultMarking;
	}

	public int calculateScore(List<Integer> questionNumber, int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		List<QuestionVo> scoreList = questionDao.selectList(csatSequence, examSequence, sectionSequence, subjectSequence);
		List<CorrectAnswerVo> answerList = correctAnswerDao.selectList(csatSequence, examSequence, sectionSequence, subjectSequence);
		int resultScore = 0;
		if (questionNumber != null && scoreList != null && answerList != null) {
			int questionNumberSize = questionNumber.size();
			int answerListSize = answerList.size();
			int scoreListSize = scoreList.size();
			if (questionNumberSize == answerListSize && questionNumberSize == scoreListSize) {
				for (int index = 0; index < questionNumberSize; index++) {
					if (questionNumber.get(index) == answerList.get(index).getObjectItemSequence()) {
						resultScore += scoreList.get(index).getScore();
					}
				}
			}
		}
		return resultScore;
	}
	
	public int calculateRating(int score, int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		List<RatingCutVo> list = ratingCutDao.selectListDetailForSolving(csatSequence, examSequence, sectionSequence, subjectSequence);
		int resultRating = 0;
		if (list != null) {
			int listSize = list.size();
			for (int index = 0; index < listSize; index++) {
				if (score >= list.get(index).getRawScore()) {
					resultRating = list.get(index).getRatingCode();
				}
			}
		}
		return resultRating;
	}
	
	public int calculateStandardScore(int score, int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		int resultStandardScore = 0;
		AverageVo averageVo = new AverageVo();
		averageVo = averageDao.selectOneDetail(csatSequence, examSequence, sectionSequence, subjectSequence);
		int maxScore = subjectDao.selectOneMaxScore(csatSequence, examSequence, sectionSequence, subjectSequence);
		resultStandardScore = (int) (((score - averageVo.getAverage()) / averageVo.getStandardDeviation()) * (maxScore / 5) + maxScore);
		return resultStandardScore;
	}
	
	public List<CorrectAnswerVo> objectQuestionCorrectAnswerList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		return correctAnswerDao.selectList(csatSequence, examSequence, sectionSequence, subjectSequence);
	}
	
	public List<TextVo> textList(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		List<TextVo> textList = new ArrayList<TextVo>();
		textList = textDao.selectList(csatSequence, examSequence, sectionSequence, subjectSequence);
		if (textList != null) {
			int textListSize = textList.size();
			for (int index = 0; index < textListSize; index++) {
				String content = "";
				int textSequence = textList.get(index).getTextSequence();
				List<TextVo> contentList = contentDao.selectList(csatSequence, examSequence, sectionSequence, subjectSequence, textSequence);
				if (contentList != null) {
					int contentListSize = contentList.size();
					for (int index2 = 0; index2 < contentListSize; index2++) {
						content += contentList.get(index2).getContent();
					}
				}
				textList.get(index).setContent(content);
			}
		}
		return textList;
	}

}

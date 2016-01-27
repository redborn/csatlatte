package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.domain.RatingCutScoreVo;
import org.redborn.csatlatte.domain.RatingCutVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.springframework.stereotype.Repository;

@Repository
public class RatingCutDaoMapper extends SqlSessionDaoSupport implements
		RatingCutDao {

	public List<ExamVo> selectList(int csatSequence) {
		return getSqlSession().selectList("exam.ratingcut.selectList", csatSequence);
	}
	
	public List<RatingCutVo> selectListDetail(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("exam.ratingcut.selectListDetail", params);
	}
	
	public List<ExamVo> selectListForCreate(int csatSequence) {
		return getSqlSession().selectList("exam.ratingcut.selectListForCreate", csatSequence);
	}
	
	public int deleteAverage(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("exam.ratingcut.deleteAverage", params);
	}
	
	public int deleteSection(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("exam.ratingcut.deleteSection", params);
	}
	
	public int deleteSubject(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("exam.ratingcut.deleteSubject", params);
	}
	
	public int deleteRatingCut(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("exam.ratingcut.deleteRatingCut", params);
	}
	
	public int deleteStudentScore(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("exam.ratingcut.deleteStudentScore", params);
	}

	public int insert(SubjectVo subjectVo, RatingCutScoreVo ratingCutScoreVo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", subjectVo.getCsatSequence());
		params.put("examSequence", subjectVo.getExamSequence());
		params.put("sectionSequence", subjectVo.getSectionSequence());
		params.put("subjectSequence", subjectVo.getSubjectSequence());
		params.put("ratingCode", ratingCutScoreVo.getRatingCode());
		params.put("rawScore", ratingCutScoreVo.getRawScore());
		params.put("standardScore", ratingCutScoreVo.getStandardScore());
		
		return getSqlSession().insert("exam.ratingcut.insert", params);
	}

}

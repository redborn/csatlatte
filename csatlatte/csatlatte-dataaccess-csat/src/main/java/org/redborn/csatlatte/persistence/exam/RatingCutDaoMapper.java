package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.RatingCutScoreVo;
import org.redborn.csatlatte.domain.SubjectVo;
import org.springframework.stereotype.Repository;

@Repository
public class RatingCutDaoMapper extends SqlSessionDaoSupport implements
		RatingCutDao {

	public List<RatingCutScoreVo> selectList(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("exam.ratingcut.selectList", params);
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

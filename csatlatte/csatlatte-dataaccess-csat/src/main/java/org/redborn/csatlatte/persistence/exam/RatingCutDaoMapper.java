package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.RatingCutScoreVo;
import org.redborn.csatlatte.domain.SubjectVo;

public class RatingCutDaoMapper extends SqlSessionDaoSupport implements
		RatingCutDao {

	public List<RatingCutScoreVo> list(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("exam.ratingcut.selectList", params);
	}

	public int insert(SubjectVo subjectVo, List<RatingCutScoreVo> ratingCutScoreVo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("subjectVo", subjectVo);
		params.put("ratingCutScoreVo", ratingCutScoreVo);
		
		return getSqlSession().insert("exam.ratingcut.insert", params);
	}

}

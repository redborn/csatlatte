package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.RatingCutVo;

public class RatingCutDaoMapper extends SqlSessionDaoSupport implements
		RatingCutDao {

	public List<RatingCutVo> list(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("csat.exam.ratingcut.selectList", params);
	}

	public int insert(RatingCutVo ratingCutVo) {
		return getSqlSession().insert("csat.exam.ratingcut.insert", ratingCutVo);
	}

}

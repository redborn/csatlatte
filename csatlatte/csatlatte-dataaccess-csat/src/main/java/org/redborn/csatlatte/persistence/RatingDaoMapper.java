package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.ExamVo;
import org.springframework.stereotype.Repository;

@Repository
public class RatingDaoMapper extends SqlSessionDaoSupport implements RatingDao {

	public ExamVo selectOne(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectOne("rating.selectOne", params);
	}
	
	public List<ExamVo> selectList(int csatSequence) {
		return getSqlSession().selectList("rating.selectList", csatSequence);
	}

}

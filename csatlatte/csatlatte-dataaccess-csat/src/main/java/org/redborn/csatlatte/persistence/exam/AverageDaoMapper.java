package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.AverageVo;
import org.springframework.stereotype.Repository;

@Repository
public class AverageDaoMapper extends SqlSessionDaoSupport implements AverageDao {

	public int selectOneStandardScore(int score, int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		params.put("score", score);
		return getSqlSession().selectOne("exam.average.selectOneStandardScore", params);
	}
	
	public List<AverageVo> selectList(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("exam.average.selectList", params);
	}
	
	public int insert(AverageVo averageVo) {
		return getSqlSession().insert("exam.average.insert", averageVo);
	}
	
	public int delete(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("exam.average.delete", params);
	}

}

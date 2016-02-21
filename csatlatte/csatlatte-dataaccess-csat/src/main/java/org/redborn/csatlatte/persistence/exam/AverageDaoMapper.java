package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.AverageVo;
import org.springframework.stereotype.Repository;

@Repository
public class AverageDaoMapper extends SqlSessionDaoSupport implements AverageDao {

	public List<AverageVo> selectList(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("exam.average.selectList", params);
	}
	
	public int insert(AverageVo averageVo) {
		return getSqlSession().insert("exam.average.insert", averageVo);
	}

}

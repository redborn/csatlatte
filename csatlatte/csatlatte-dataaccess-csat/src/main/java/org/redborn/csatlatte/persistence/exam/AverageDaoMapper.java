package org.redborn.csatlatte.persistence.exam;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.AverageVo;

public class AverageDaoMapper extends SqlSessionDaoSupport implements AverageDao {

	public int insert(AverageVo averageVo) {
		return getSqlSession().insert("csat.exam.average.insert", averageVo);
	}

}

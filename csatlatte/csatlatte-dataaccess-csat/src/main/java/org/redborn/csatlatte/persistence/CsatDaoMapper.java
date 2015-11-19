package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CsatVo;
import org.springframework.stereotype.Repository;

@Repository
public class CsatDaoMapper extends SqlSessionDaoSupport implements CsatDao {

	public List<CsatVo> selectListYear() {
		return getSqlSession().selectList("csat.selectListYear");
	}
	
}

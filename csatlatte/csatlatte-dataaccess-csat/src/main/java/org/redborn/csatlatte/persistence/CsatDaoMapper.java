package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CsatDaoMapper extends SqlSessionDaoSupport implements CsatDao {

	public List<CsatDao> selectListYear() {
		return getSqlSession().selectList("csat.selectListYear");
	}
	
}

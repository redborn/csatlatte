package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CsatDaoMapper extends SqlSessionDaoSupport implements CsatDao {

	public List<CsatDao> yearList() {
		return getSqlSession().selectList("csat.select");
	}
	
}

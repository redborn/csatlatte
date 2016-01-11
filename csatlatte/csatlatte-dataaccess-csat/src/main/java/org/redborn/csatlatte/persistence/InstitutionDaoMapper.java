package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.InstitutionVo;
import org.springframework.stereotype.Repository;

@Repository
public class InstitutionDaoMapper extends SqlSessionDaoSupport implements InstitutionDao {

	public List<InstitutionVo> selectList() {
		return getSqlSession().selectList("institution.selectList");
	}

}

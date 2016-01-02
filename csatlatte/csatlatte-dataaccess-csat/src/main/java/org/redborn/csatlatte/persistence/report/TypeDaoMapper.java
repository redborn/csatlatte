package org.redborn.csatlatte.persistence.report;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.TypeVo;
import org.springframework.stereotype.Repository;

@Repository
public class TypeDaoMapper extends SqlSessionDaoSupport implements TypeDao {

	public List<TypeVo> selectList() {
		return getSqlSession().selectList("report.type.selectList");
	}

}

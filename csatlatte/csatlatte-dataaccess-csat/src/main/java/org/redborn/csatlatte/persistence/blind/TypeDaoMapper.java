package org.redborn.csatlatte.persistence.blind;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.TypeVo;
import org.springframework.stereotype.Repository;

@Repository
public class TypeDaoMapper extends SqlSessionDaoSupport implements TypeDao {

	public List<TypeVo> selectList() {
		return getSqlSession().selectList("blind.type.selectList");
	}

}

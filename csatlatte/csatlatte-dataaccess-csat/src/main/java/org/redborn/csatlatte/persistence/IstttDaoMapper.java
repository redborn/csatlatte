package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.IstttVo;
import org.springframework.stereotype.Repository;

@Repository
public class IstttDaoMapper extends SqlSessionDaoSupport implements IstttDao {

	public List<IstttVo> selectList() {
		return getSqlSession().selectList("isttt.selectList");
	}

}

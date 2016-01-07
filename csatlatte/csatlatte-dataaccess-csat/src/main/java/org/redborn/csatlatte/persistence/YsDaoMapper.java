package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.YsVo;
import org.springframework.stereotype.Repository;

@Repository
public class YsDaoMapper extends SqlSessionDaoSupport implements YsDao {

	public List<YsVo> selectList() {
		return getSqlSession().selectList("ys.selectList");
	}

}

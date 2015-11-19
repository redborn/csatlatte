package org.redborn.csatlatte.persistence.faq;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.FaqTypeVo;
import org.springframework.stereotype.Repository;

@Repository
public class TypeDaoMapper extends SqlSessionDaoSupport implements TypeDao {

	public List<FaqTypeVo> selectList() {
		return getSqlSession().selectList("faq.type.selectList");
	}

}

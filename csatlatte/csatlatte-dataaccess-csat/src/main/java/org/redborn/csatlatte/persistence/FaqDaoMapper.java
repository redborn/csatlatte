package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.FaqVo;
import org.springframework.stereotype.Repository;

@Repository
public class FaqDaoMapper extends SqlSessionDaoSupport implements FaqDao {

	public List<FaqVo> selectList(int faqTypeSequence) {
		return getSqlSession().selectList("faq.selectList", faqTypeSequence);
	}

}

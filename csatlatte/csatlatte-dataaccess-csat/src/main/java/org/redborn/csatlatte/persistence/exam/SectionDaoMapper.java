package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.SectionVo;
import org.springframework.stereotype.Repository;

@Repository
public class SectionDaoMapper extends SqlSessionDaoSupport implements SectionDao {

	public List<SectionVo> selectList(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		return getSqlSession().selectList("exam.section.selectList", params);
	}

}

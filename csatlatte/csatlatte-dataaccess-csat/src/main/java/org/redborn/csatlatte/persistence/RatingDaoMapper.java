package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.ExamVo;
import org.springframework.stereotype.Repository;

@Repository
public class RatingDaoMapper extends SqlSessionDaoSupport implements RatingDao {

	public List<ExamVo> selectList(int csatSequence) {
		return getSqlSession().selectList("rating.selectList", csatSequence);
	}

}

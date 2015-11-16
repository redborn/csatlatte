package org.redborn.csatlatte.persistence;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.ExamVo;
import org.redborn.csatlatte.persistence.ExamDao;

public class ExamDaoMapper extends SqlSessionDaoSupport implements ExamDao {

	public List<ExamVo> selectListExam(int csatSequence) {
		return getSqlSession().selectList("exam.selectListExam",csatSequence);
	}

	public int insert(ExamVo examVo) {
		return getSqlSession().insert("exam.insert",examVo);
	}

	public int update(ExamVo examVo) {
		return getSqlSession().update("exam.update",examVo);
	}

	public int delete(int examSequence) {
		return getSqlSession().delete("exam.delete",examSequence);
	}

}
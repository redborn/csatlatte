package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.ExamVo;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDaoMapper extends SqlSessionDaoSupport implements ExamDao {
	
	public int selectOneCount(int csatSequence, String search) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("search", search);
		
		return getSqlSession().selectOne("exam.selectOneCount", params);
	}
	
	public List<ExamVo> selectListExam(int csatSequence) {
		return getSqlSession().selectList("exam.selectListExam", csatSequence);
	}

	public List<ExamVo> selectListExamForManage(int csatSequence) {
		
		return getSqlSession().selectList("exam.selectListExamForManage", csatSequence);
	}
	
	public int insert(ExamVo examVo) {
		return getSqlSession().insert("exam.insert", examVo);
	}

	public int update(ExamVo examVo) {
		return getSqlSession().update("exam.update", examVo);
	}

	public int delete(int examSequence) {
		return getSqlSession().delete("exam.delete", examSequence);
	}
	
	public List<ExamVo> selectListExamOneForManage(int examSequence) {
		return getSqlSession().selectList("exam.selectListExamOneForManage", examSequence);
	}

}
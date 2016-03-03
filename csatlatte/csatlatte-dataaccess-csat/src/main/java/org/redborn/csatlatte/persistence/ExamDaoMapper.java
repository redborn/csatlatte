package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.ExamVo;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDaoMapper extends SqlSessionDaoSupport implements ExamDao {
	
	public int selectOneCountMax(int csatSequence) {
		return getSqlSession().selectOne("exam.selectOneCountMax", csatSequence);
	}
	
	public List<ExamVo> selectListDetailForManage(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("exam.selectListDetailForManage", params);
	}
	
	public List<ExamVo> selectListExam(String year, int yearStudentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("year", year);
		params.put("yearStudentSequence", yearStudentSequence);
		return getSqlSession().selectList("exam.selectListExam", params);
	}
	
	public List<String> selectListYear(int yearStudentSequence) {
		return getSqlSession().selectList("exam.selectListYear", yearStudentSequence);
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

	public int delete(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("exam.delete", params);
	}

}

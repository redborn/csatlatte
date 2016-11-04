package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.SubjectVo;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDaoMapper extends SqlSessionDaoSupport implements SubjectDao {

	public int selectOneMaxScore(int csatSequence, int examSequence, int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		
		return getSqlSession().selectOne("exam.subject.selectOneMaxScore", params);
	}
	
	public List<SubjectVo> selectList(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		return getSqlSession().selectList("exam.subject.selectList", params);
	}

	public List<SubjectVo> selectListForSolving(int csatSequence,
			int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		return getSqlSession().selectList("exam.subject.selectListForSolving", params);
	}

	public int selectExamTime(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		Object object = getSqlSession().selectOne("exam.subject.selectExamTime", params);
		return (Integer) (object != null ? object : 0);
	}

	public String selectSubjectName(int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		return getSqlSession().selectOne("exam.subject.selectSubjectName", params);
	}
	
	public int insert(SubjectVo subjectVo) {
		return getSqlSession().insert("exam.subject.insert", subjectVo);
	}
	
	public int delete(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().delete("exam.subject.delete", params);
	}

}

package org.redborn.csatlatte.persistence.exam.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.GradeRatingVo;
import org.redborn.csatlatte.domain.GradeStandardscoreVo;
import org.redborn.csatlatte.domain.GradeVo;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreDaoMapper extends SqlSessionDaoSupport implements ScoreDao {

	public int insert(GradeVo gradeVo) {
		return getSqlSession().insert("exam.student.score.insert", gradeVo);
	}

	public int update(GradeVo gradeVo) {
		return getSqlSession().update("exam.student.score.update", gradeVo);
	}

	public int delete(int studentSequence, int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentSequence", studentSequence);
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		
		return getSqlSession().delete("exam.student.score.delete", params);
	}

	public List<GradeVo> selectList(int csatSequence, int examSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectList("exam.student.score.selectList", params);
	}
	
	public List<GradeVo> selectListExamStudent(int csatSequence, int examSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		
		return getSqlSession().selectList("exam.student.score.selectListExamStudent", params);
	}

	public List<GradeRatingVo> selectListRating(int csatSequence, int examSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("studentSequence", studentSequence);
		
		
		return getSqlSession().selectList("exam.student.score.selectListRating", params);
	}

	public List<GradeStandardscoreVo> selectListStandardscore(int csatSequence, int examSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectList("exam.student.score.selectListStandardscore", params);
	}

}

package org.redborn.csatlatte.persistence.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.GradeRatingVo;
import org.redborn.csatlatte.domain.GradeStandardscoreVo;
import org.redborn.csatlatte.domain.GradeVo;

public class ScoreDaoMapper extends SqlSessionDaoSupport implements ScoreDao {

	public int insert(GradeVo gradeVo) {
		return getSqlSession().insert("exam.studentScore.insert", gradeVo);
	}

	public int update(GradeVo gradeVo) {
		return getSqlSession().update("exam.studentScore.update", gradeVo);
	}

	public int delete(int studentSequence, int csatSequence, int examSequence,
			int sectionSequence, int subjectSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentSequence", studentSequence);
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("sectionSequence", sectionSequence);
		params.put("subjectSequence", subjectSequence);
		
		return getSqlSession().delete("exam.studentScore.delete", params);
	}

	public List<GradeVo> selectList(int csatSequence, int examSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectList("exam.studentScore.selectList", params);
	}

	public List<GradeRatingVo> selectListRating(int csatSequence, int examSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("studentSequence", studentSequence);
		
		
		return getSqlSession().selectList("exam.studentScore.selectListRating", params);
	}

	public List<GradeStandardscoreVo> selectListStandardscore(int csatSequence, int examSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("csatSequence", csatSequence);
		params.put("examSequence", examSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().selectList("exam.studentScore.selectListStandardscore", params);
	}

}

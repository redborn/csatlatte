package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.QnaForManageVo;
import org.redborn.csatlatte.domain.QnaForStudentVo;
import org.redborn.csatlatte.domain.QnaVo;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDaoMapper extends SqlSessionDaoSupport implements QnaDao {

	public QnaVo selectOne(int qnaSequence) {
		return getSqlSession().selectOne("qna.selectOne", qnaSequence);
	}
	
	public int selectOneMaxQnaSequence() {
		return getSqlSession().selectOne("qna.selectOneMaxQnaSequence");
	}

	public List<QnaForManageVo> selectListForManage(String search, int begin) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("search", search);
		params.put("begin", begin);
		
		return getSqlSession().selectList("qna.selectListForManage", params);
	}

	public List<QnaForStudentVo> selectListForStudent(int studentSequence, int begin) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentSequence", studentSequence);
		params.put("begin", begin);
		
		return getSqlSession().selectList("qna.selectListForStudent", params);
	}
	
	public int insert(int qnaSequence, int studentSequence) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("qnaSequence", qnaSequence);
		params.put("studentSequence", studentSequence);
		
		return getSqlSession().insert("qna.insert", params);
	}

	public int updateUseYnN(int qnaSequence) {
		return getSqlSession().update("qna.updateUseYnN", qnaSequence);
	}

}

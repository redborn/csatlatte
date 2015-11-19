package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.StudentVo;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoMapper extends SqlSessionDaoSupport implements StudentDao {

	public int selectOne(String id, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		
		return getSqlSession().selectOne("student.selectOne", map);
	}
	
	public int selectOneCountPassword(int studentSequence, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentSequence", studentSequence);
		map.put("password",	password);
		
		return getSqlSession().selectOne("student.selectOneCountPassword", map);
	}
	
	public int selectOneCountIsPassword(String id, String securityAnswer) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("securityAnswer", securityAnswer);
		
		return getSqlSession().selectOne("student.selectOneCountIsPassword", map);
	}
	
	public String selectOneId(String nickname, String securityAnswer) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickname", nickname);
		map.put("securityAnswer", securityAnswer);
		
		return getSqlSession().selectOne("student.selectOneId", map);
	}
	
	public int selectOneMaxStudentSequence() {
		return getSqlSession().selectOne("student.selectOneMaxStudentSequence");
	}
	
	public List<StudentVo> selectList(String studentId, String nickname) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentId", studentId);
		map.put("nickname", nickname);
		
		return getSqlSession().selectList("student.selectList", map);
	}

	public List<StudentVo> selectListCountYmd(String ymd) {
		return getSqlSession().selectList("student.selectListCountYmd", ymd);
	}

	public List<StudentVo> selectListCountYm(String ym) {
		return getSqlSession().selectList("student.selectListCountYm", ym);
	}

	public List<StudentVo> selectListCountYear(String year) {
		return getSqlSession().selectList("student.selectListCountYear", year);
	}
	
	public int insert(StudentVo studentVo) {
		return getSqlSession().insert("student.insert", studentVo);
	}

	public int updatePassword(int studentSequence, String newPassword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("studentSequence", studentSequence);
		map.put("newPassword", newPassword);
		
		return getSqlSession().update("student.updatePassword", map);
	}

	public int updateInformation(StudentVo studentVo) {
		return getSqlSession().update("student.updateInformation", studentVo);
	}

	public int updateUseYnN(int studentSequence) {
		return getSqlSession().update("student.updateUseYnN", studentSequence);
	}

}

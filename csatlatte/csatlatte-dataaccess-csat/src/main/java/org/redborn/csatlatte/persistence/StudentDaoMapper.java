package org.redborn.csatlatte.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.StudentVo;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoMapper extends SqlSessionDaoSupport implements StudentDao {

	public StudentVo selectOne(String id, String password) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("password", password);
		
		return getSqlSession().selectOne("student.selectOne", params);
	}
	
	public StudentVo selectOneDetail(int studentSequence) {
		return getSqlSession().selectOne("student.selectOneDetail", studentSequence);
	}
	
	public int selectOneCountPassword(int studentSequence, String password) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentSequence", studentSequence);
		params.put("password",	password);
		
		return getSqlSession().selectOne("student.selectOneCountPassword", params);
	}
	
	public int selectOneCountOverlapId(String studentId) {
		return getSqlSession().selectOne("student.selectOneCountOverlapId", studentId);
	}
	
	public int selectOneCountOverlapNickname(String nickname) {
		return getSqlSession().selectOne("student.selectOneCountOverlapNickname", nickname);
	}
	
	public int selectOneCountIsPassword(String id, String securityAnswer) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("securityAnswer", securityAnswer);
		
		return getSqlSession().selectOne("student.selectOneCountIsPassword", params);
	}
	
	@SuppressWarnings("unchecked")
	public String selectOneId(String nickname, String securityAnswer) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nickname", nickname);
		params.put("securityAnswer", securityAnswer);
		
		Map<String, Object> data = (Map<String, Object>) getSqlSession().selectOne("student.selectOneId", params);
		String result = null;
		
		if (data != null) {
			result = (String) data.get("studentId");
		}
		
		return result;
	}
	
	public int selectOneMaxStudentSequence() {
		return getSqlSession().selectOne("student.selectOneMaxStudentSequence");
	}
	
	public int selectOneCount(String search) {
		return getSqlSession().selectOne("student.selectOneCount", search);
	}
	
	public int selectOneStudentSequence(String nickname) {
		return getSqlSession().selectOne("student.selectOneStudentSequence", nickname);
	}
	
	public int selectOneStudentSequenceById(String studentId) {
		return getSqlSession().selectOne("student.selectOneStudentSequenceById", studentId);
	}
	
	public String selectPhotoName(int studentSequence) {
		return getSqlSession().selectOne("student.selectPhotoName", studentSequence);
	}
	
	public String selectPhotoCode(int studentSequence) {
		return getSqlSession().selectOne("student.selectPhotoCode", studentSequence);
	}
	
	public List<StudentVo> selectList(String search, int pageNumber) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("search", search);
		params.put("pageNumber", pageNumber);
		
		return getSqlSession().selectList("student.selectList", params);
	}

	public List<CountVo> selectListCountYmd(String ymd) {
		return getSqlSession().selectList("student.selectListCountYmd", ymd);
	}

	public List<CountVo> selectListCountYm(String ym) {
		return getSqlSession().selectList("student.selectListCountYm", ym);
	}

	public List<CountVo> selectListCountYear(String year) {
		return getSqlSession().selectList("student.selectListCountYear", year);
	}

	public String selectOneCreateHmsmWhereStudentSequence(int studentSequence) {
		return getSqlSession().selectOne("student.selectOneCreateHmsmWhereStudentSequence", studentSequence);
	}

	public String selectOneCreateHmsmWhereStudentId(String studentId) {
		return getSqlSession().selectOne("student.selectOneCreateHmsmWhereStudentId", studentId);
	}
	
	public int insert(StudentVo studentVo) {
		return getSqlSession().insert("student.insert", studentVo);
	}

	public int updatePassword(int studentSequence, String newPassword) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentSequence", studentSequence);
		params.put("newPassword", newPassword);
		
		return getSqlSession().update("student.updatePassword", params);
	}

	public int updateInformation(StudentVo studentVo) {
		return getSqlSession().update("student.updateInformation", studentVo);
	}

	public int updateUseYnN(int studentSequence) {
		return getSqlSession().update("student.updateUseYnN", studentSequence);
	}
	
	public int updateUseYnNRecovery(int studentSequence) {
		return getSqlSession().update("student.updateUseYnNRecovery",studentSequence);
	}

}

package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.StudentVo;

public interface StudentDao {
	
	public int selectOneCountPassword(int studentSequence, String password);
	public int updatePassword(int studentSequence, String newPassword);
	public int updateInformation(StudentVo studentVo);
	public int selectOneMaxStudentSequence();
	public int insert(StudentVo studentVo);
	public String selectOneId(String nickname, String securityAnswer);
	public int selectOneCountPassword(String id, String securityAnswer);
	public int selectOne(String id, String password);
	public int updateUseYnN(int studentSequence);
	public List<StudentVo> selectListCountYmd(String ymd);
	public List<StudentVo> selectListCountYm(String ym);
	public List<StudentVo> selectListCountYear(String year);
	public List<StudentVo> selectList(String studentId, String nickname);
	
}

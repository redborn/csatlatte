package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.StudentVo;

public interface StudentDao {
	
	public int selectOne(String id, String password);
	public int selectOneCountPassword(int studentSequence, String password);
	public int selectOneCountIsPassword(String id, String securityAnswer);
	public String selectOneId(String nickname, String securityAnswer);
	public int selectOneMaxStudentSequence();
	public List<StudentVo> selectList(String studentId, String nickname);
	public List<StudentVo> selectListCountYmd(String ymd);
	public List<StudentVo> selectListCountYm(String ym);
	public List<StudentVo> selectListCountYear(String year);
	public int insert(StudentVo studentVo);
	public int updateInformation(StudentVo studentVo);
	public int updatePassword(int studentSequence, String newPassword);
	public int updateUseYnN(int studentSequence);
	
}

package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.StudentVo;

public interface StudentDao {
	
	public StudentVo selectOne(String id, String password);
	public StudentVo selectOneDetail(int studentSequence);
	public int selectOneCountPassword(int studentSequence, String password);
	public int selectOneCountOverlapId(String studentId);
	public int selectOneCountOverlapNickname(String nickname);
	public int selectOneCountIsPassword(String id, String securityAnswer);
	public String selectOneId(String nickname, String securityAnswer);
	public int selectOneMaxStudentSequence();
	public int selectOneCount(String search);
	public List<StudentVo> selectList(String search, int pageNumber);
	public List<CountVo> selectListCountYmd(String ymd);
	public List<CountVo> selectListCountYm(String ym);
	public List<CountVo> selectListCountYear(String year);
	public String selectOneCreateHmsmWhereStudentSequence(int studentSequence);
	public String selectOneCreateHmsmWhereStudentId(String studentId);
	public int insert(StudentVo studentVo);
	public int updateInformation(StudentVo studentVo);
	public int updatePassword(int studentSequence, String newPassword);
	public int updateUseYnN(int studentSequence);
	public int updateUseYnNRecovery(int studentSequence);
	
}

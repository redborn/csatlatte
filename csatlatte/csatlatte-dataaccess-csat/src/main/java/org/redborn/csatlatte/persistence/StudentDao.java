package org.redborn.csatlatte.persistence;

import java.util.List;

import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;

public interface StudentDao {
	
	public StudentVo selectOne(String id, String password);
	public StudentVo selectOneDetail(int studentSequence);
	public int selectOneCountPassword(int studentSequence, String password);
	public int selectOneCountIsPassword(String id, String securityAnswer);
	public String selectOneId(String nickname, String securityAnswer);
	public int selectOneMaxStudentSequence();
	public int selectOneCount(String search);
	public List<StudentVo> selectList(String search, int pageNumber);
	public List<YmdCountVo> selectListCountYmd(String ymd);
	public List<YmCountVo> selectListCountYm(String ym);
	public List<YearCountVo> selectListCountYear(String year);
	public int insert(StudentVo studentVo);
	public int updateInformation(StudentVo studentVo);
	public int updatePassword(int studentSequence, String newPassword);
	public int updateUseYnN(int studentSequence);
	
}

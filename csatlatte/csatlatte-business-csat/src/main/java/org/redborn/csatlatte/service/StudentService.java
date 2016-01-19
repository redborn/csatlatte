package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.SecurityQuestionVo;
import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.domain.YsVo;

public interface StudentService {

	public boolean changePassword(int studentSequence, String password, String newPassword);
	public boolean changePasswordForFind(int studentSequence, String newPassword);
	public boolean changeInformation(StudentVo studentVo);
	public boolean changeSecurity(StudentSecurityQuestionVo studentSecurityQuestionVo);
	public boolean join(StudentVo studentVo, StudentSecurityQuestionVo studentSecurityQuestionVo);
	public String findId(String nickname, String securityAnswer);
	public boolean isPassword(String id, String securityAnswer);
	public boolean overlapCheckId(String studentId);
	public boolean overlapCheckNickname(String nickname);
	public StudentVo information(String id, String password);
	public StudentVo information(int studentSequence);
	public boolean lock(int studentSequence);
	public boolean recovery(int studentSequence);
	public List<CountVo> dailyJoinCountList(String ymd);
	public List<CountVo> monthlyJoinCountList(String ym);
	public List<CountVo> annualJoinCountList(String year);
	public List<CountVo> dailyConnectionCount(String ymd);
	public List<CountVo> monthlyConnectionCount(String ym);
	public List<CountVo> annualConnectionCount(String year);
	public List<StudentVo> userList(String search, int pageNumber);
	public String securityQuestion(int studentSequence);
	public int amountStudent(String search);
	public List<YsVo> ysList();
	public List<SecurityQuestionVo> securityQuestionList();
	public int nicknameStudentSequence(String nickname);
	public int studentIdStudentSequence(String studentId);
	
}

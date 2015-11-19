package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;

public interface StudentService {

	public boolean changePassword(int studentSequence, String password, String newPassword);
	public boolean changeInformation(StudentVo studentVo);
	public boolean changeSecurity(StudentSecurityQuestionVo studentSecurityQuestionVo);
	public boolean join(StudentVo studentVo, StudentSecurityQuestionVo studentSecurityQuestionVo);
	public String findId(String nickname, String securityAnswer);
	public boolean isPassword(String id, String securityAnswer);
	public boolean information(String id, String password);
	public boolean lock(int studentSequence);
	public List<YmdCountVo> dailyJoinCountList(String ymd);
	public List<YmCountVo> monthlyJoinCountList(String ym);
	public List<YearCountVo> annualJoinCountList(String year);
	public List<YmdCountVo> dailyConnectionCount(String ymd);
	public List<YmCountVo> monthlyConnectionCount(String ym);
	public List<YearCountVo> annualConnectionCount(String year);
	public List<StudentVo> userList(String studentId, String nickname);
	public String securityQuestion(int studentSequence);
	
}

package org.redborn.csatlatte.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.SecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.domain.YearStudentVo;

public interface StudentService {

	public boolean checkPassword(int studentSequence, String password);
	public boolean changePassword(int studentSequence, String password, String newPassword);
	public boolean changePassword(String studentId, String securityAnswer, String newPassword);
	public boolean changeInformation(StudentVo studentVo, File photo, boolean photoDelete);
	public boolean changeSecurity(StudentSecurityQuestionVo studentSecurityQuestionVo);
	public boolean join(StudentVo studentVo, StudentSecurityQuestionVo studentSecurityQuestionVo, File photo);
	public String findId(String nickname, String securityAnswer);
	public boolean isPassword(String id, String securityAnswer);
	public boolean isId(String studentId);
	public boolean isNickname(String nickname);
	public StudentVo information(String id, String password);
	public StudentVo information(int studentSequence);
	public boolean connection(int studentSequence, String userAgent, String sessionId, String ip);
	public boolean lock(int studentSequence);
	public boolean recovery(int studentSequence);
	public List<CountVo> dailyJoinCountList(String ymd);
	public List<CountVo> monthlyJoinCountList(String ym);
	public List<CountVo> annualJoinCountList(String year);
	public List<CountVo> dailyConnectionCount(String ymd);
	public List<CountVo> monthlyConnectionCount(String ym);
	public List<CountVo> annualConnectionCount(String year);
	public List<StudentVo> userList(String search, int pageNumber);
	public String securityQuestion(String nickname);
	public String securityQuestion(int studentSequence);
	public int amountStudent(String search);
	public List<YearStudentVo> yearStudentList();
	public List<SecurityQuestionVo> securityQuestionList();
	public int getStudentSequence(String studentId);
	public String getPhotoName(int studentSequence);
	public InputStream getInputStream(int studentSequence);
	
}

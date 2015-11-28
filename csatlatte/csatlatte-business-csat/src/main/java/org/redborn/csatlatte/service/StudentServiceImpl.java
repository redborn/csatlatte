package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.StudentInformationVo;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.domain.YearCountVo;
import org.redborn.csatlatte.domain.YmCountVo;
import org.redborn.csatlatte.domain.YmdCountVo;
import org.redborn.csatlatte.persistence.StudentDao;
import org.redborn.csatlatte.persistence.student.ConnectionDao;
import org.redborn.csatlatte.persistence.student.SecurityQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private ConnectionDao connectionDao;
	@Autowired
	private SecurityQuestionDao securityQuestionDao;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public boolean changePassword(int studentSequence, String password, String newPassword) {
		boolean result = false;
		
		if (studentDao.selectOneCountPassword(studentSequence, password) == 1 
				&& studentDao.updatePassword(studentSequence, newPassword) == 1) {
			result = true;
		}
		
		return result;
	}

	public boolean changeInformation(StudentVo studentVo) {
		return studentDao.updateInformation(studentVo) == 1;
	}

	public boolean changeSecurity(StudentSecurityQuestionVo studentSecurityQuestionVo) {
		return securityQuestionDao.updateContent(studentSecurityQuestionVo) == 1;
	}

	public boolean join(StudentVo studentVo, StudentSecurityQuestionVo studentSecurityQuestionVo) {
		boolean result = false;
		int maxStudentSequence = studentDao.selectOneMaxStudentSequence();
		studentVo.setStudentSequence(maxStudentSequence);
		studentSecurityQuestionVo.setStudentSequence(maxStudentSequence);
		
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("Student Join Transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		try {
			if (studentDao.insert(studentVo) == 1 && securityQuestionDao.insert(studentSecurityQuestionVo) == 1) {
				result = true;
			}
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);
		}
		transactionManager.commit(transactionStatus);
		return result;
	}

	public String findId(String nickname, String securityAnswer) {
		return studentDao.selectOneId(nickname, securityAnswer);
	}

	public boolean isPassword(String id, String securityAnswer) {
		return studentDao.selectOneCountIsPassword(id, securityAnswer) == 1;
	}

	public StudentInformationVo information(String id, String password) {
		return studentDao.selectOne(id, password);
	}

	public boolean lock(int studentSequence) {
		return studentDao.updateUseYnN(studentSequence) == 1;
	}

	public List<YmdCountVo> dailyJoinCountList(String ymd) {
		return studentDao.selectListCountYmd(ymd);
	}

	public List<YmCountVo> monthlyJoinCountList(String ym) {
		return studentDao.selectListCountYm(ym);
	}

	public List<YearCountVo> annualJoinCountList(String year) {
		return studentDao.selectListCountYear(year);
	}

	public List<YmdCountVo> dailyConnectionCount(String ymd) {
		return connectionDao.selectListCountYmd(ymd);
	}

	public List<YmCountVo> monthlyConnectionCount(String ym) {
		return connectionDao.selectListCountYm(ym);
	}

	public List<YearCountVo> annualConnectionCount(String year) {
		return connectionDao.selectListCountYear(year);
	}

	public List<StudentVo> userList(String search, int pageNumber) {
		return studentDao.selectList(search, pageNumber);
	}

	public String securityQuestion(int studentSequence) {
		return securityQuestionDao.selectOne(studentSequence);
	}

}

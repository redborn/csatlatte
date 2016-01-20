package org.redborn.csatlatte.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.SecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.domain.YsVo;
import org.redborn.csatlatte.persistence.SecurityQuestionDao;
import org.redborn.csatlatte.persistence.StudentDao;
import org.redborn.csatlatte.persistence.YsDao;
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
	private org.redborn.csatlatte.persistence.connection.StudentDao connectionStudentDao;
	@Autowired
	private org.redborn.csatlatte.persistence.student.SecurityQuestionDao studentSecurityQuestionDao;
	@Autowired
	private SecurityQuestionDao securityQuestionDao;
	@Autowired
	private PlatformTransactionManager transactionManager;
	@Autowired
	private YsDao ysDao;
	
	public boolean changePassword(int studentSequence, String password, String newPassword) {
		boolean result = false;
		if (studentDao.selectOneCountPassword(studentSequence, makePassword(studentSequence, password)) == 1 
				&& studentDao.updatePassword(studentSequence, makePassword(studentSequence, newPassword)) == 1) {
			result = true;
		}
		return result;
	}
	
	public boolean changePasswordForFind(int studentSequence, String newPassword) {
		return studentDao.updatePassword(studentSequence, newPassword) == 1;
	}

	public boolean changeInformation(StudentVo studentVo) {
		return studentDao.updateInformation(studentVo) == 1;
	}

	public boolean changeSecurity(StudentSecurityQuestionVo studentSecurityQuestionVo) {
		return studentSecurityQuestionDao.updateContent(studentSecurityQuestionVo) == 1;
	}

	public boolean join(StudentVo studentVo, StudentSecurityQuestionVo studentSecurityQuestionVo) {
		boolean result = false;
		int maxStudentSequence = studentDao.selectOneMaxStudentSequence();
		studentVo.setStudentSequence(maxStudentSequence);
		Date createDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmssSSS");
		studentVo.setCreateDate(createDate);
		studentVo.setStudentPassword(new StringBuilder(simpleDateFormat.format(createDate)).append(studentVo.getStudentPassword()).toString());
		studentSecurityQuestionVo.setStudentSequence(maxStudentSequence);
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("Student Join Transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		try {
			if (studentDao.insert(studentVo) == 1 && studentSecurityQuestionDao.insert(studentSecurityQuestionVo) == 1) {
				result = true;
			}
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);
		}
		if (result) {
			transactionManager.commit(transactionStatus);
		} else {
			transactionManager.rollback(transactionStatus);
		}
		return result;
	}

	public String findId(String nickname, String securityAnswer) {
		return studentDao.selectOneId(nickname, securityAnswer);
	}

	public boolean isPassword(String id, String securityAnswer) {
		return studentDao.selectOneCountIsPassword(id, securityAnswer) == 1;
	}
	
	public boolean overlapCheckId(String studentId) {
		return studentDao.selectOneCountOverlapId(studentId) == 1;
	}
	
	public boolean overlapCheckNickname(String nickname) {
		return studentDao.selectOneCountOverlapNickname(nickname) == 1;
	}

	public StudentVo information(String id, String password) {
		return studentDao.selectOne(id, makePassword(id, password));
	}
	
	public StudentVo information(int studentSequence) {
		return studentDao.selectOneDetail(studentSequence);
	}

	public boolean lock(int studentSequence) {
		return studentDao.updateUseYnN(studentSequence) == 1;
	}
	
	public boolean recovery(int studentSequence) {
		return studentDao.updateUseYnNRecovery(studentSequence) == 1;
	}
	
	private List<CountVo> margeCountVoList(List<CountVo> connectionYmdCountVos, int begin, int end) {
		List<CountVo> ymdCountVos = new ArrayList<CountVo>();
		
		int connectionYmdCountVosIndex = 0;
		int connectionYmdCountVosSize = connectionYmdCountVos != null ? connectionYmdCountVos.size() : 0;
		
		for (int index = begin; index <= end; index++) {
			CountVo ymdCountVo = new CountVo();
			
			int sumCount = 0;
			
			if (connectionYmdCountVosIndex < connectionYmdCountVosSize) {
				CountVo connectionCountVo = connectionYmdCountVos.get(connectionYmdCountVosIndex);
				if (connectionCountVo.getKey() == index) {
					sumCount = connectionCountVo.getCount();
					connectionYmdCountVosIndex++;
				}
			}
			
			ymdCountVo.setKey(index);
			ymdCountVo.setCount(sumCount);
			
			ymdCountVos.add(ymdCountVo);
		}
		
		return ymdCountVos;
	}

	public List<CountVo> dailyJoinCountList(String ymd) {
		return margeCountVoList(studentDao.selectListCountYmd(ymd), 0, 23);
	}

	public List<CountVo> monthlyJoinCountList(String ym) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(ym.substring(0, 4)), Integer.parseInt(ym.substring(5, 6)) - 1, 1);
		return margeCountVoList(studentDao.selectListCountYm(ym), 1, calendar.getActualMaximum(Calendar.DATE));
	}

	public List<CountVo> annualJoinCountList(String year) {
		return margeCountVoList(studentDao.selectListCountYear(year), 1, 12);
	}

	public List<CountVo> dailyConnectionCount(String ymd) {
		return margeCountVoList(connectionStudentDao.selectListCountYmd(ymd), 0, 23);
	}

	public List<CountVo> monthlyConnectionCount(String ym) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(ym.substring(0, 4)), Integer.parseInt(ym.substring(5, 6)) - 1, 1);
		return margeCountVoList(connectionStudentDao.selectListCountYm(ym), 1, calendar.getActualMaximum(Calendar.DATE));
	}

	public List<CountVo> annualConnectionCount(String year) {
		return margeCountVoList(connectionStudentDao.selectListCountYear(year), 1, 12);
	}

	public List<StudentVo> userList(String search, int pageNumber) {
		return studentDao.selectList(search, pageNumber);
	}

	public String securityQuestion(String nickname) {
		return securityQuestion(studentDao.selectOneStudentSequence(nickname));
	}

	public String securityQuestion(int studentSequence) {
		return securityQuestionDao.selectOne(studentSequence);
	}
	
	public int amountStudent(String search) {
		return studentDao.selectOneCount(search);
	}
	
	public List<YsVo> ysList() {
		return ysDao.selectList();
	}
	
	/**
	 * 비밀번호를 만듭니다.
	 * 
	 * @param studentId 학생 ID
	 * @param password 비밀번호
	 * @return 생성된 비밀번호
	 */
	private String makePassword(String studentId, String password) {
		String hmsm = studentDao.selectOneCreateHmsmWhereStudentId(studentId);
		if (hmsm == null) {
			hmsm = "";
		}
		return new StringBuilder(hmsm).append(password).toString();
	}
	
	/**
	 * 비밀번호를 만듭니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 * @param password 비밀번호
	 * @return 생성된 비밀번호
	 */
	private String makePassword(int studentSequence, String password) {
		String hmsm = studentDao.selectOneCreateHmsmWhereStudentSequence(studentSequence);
		if (hmsm == null) {
			hmsm = "";
		}
		return new StringBuilder(hmsm).append(password).toString();
	}
	
	public List<SecurityQuestionVo> securityQuestionList() {
		return securityQuestionDao.selectList();
	}
	
	public int getStudentSequence(String studentId) {
		return studentDao.selectOneStudentSequenceById(studentId);
	}

}

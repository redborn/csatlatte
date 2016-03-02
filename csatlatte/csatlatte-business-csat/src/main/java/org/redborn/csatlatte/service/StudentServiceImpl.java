package org.redborn.csatlatte.service;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.redborn.csatlatte.commons.amazonaws.services.s3.CsatAmazonS3;
import org.redborn.csatlatte.commons.amazonaws.services.s3.CsatAmazonS3Prefix;
import org.redborn.csatlatte.domain.CountVo;
import org.redborn.csatlatte.domain.SecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.domain.YearStudentVo;
import org.redborn.csatlatte.persistence.SecurityQuestionDao;
import org.redborn.csatlatte.persistence.StudentDao;
import org.redborn.csatlatte.persistence.YearStudentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class StudentServiceImpl implements StudentService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private org.redborn.csatlatte.persistence.connection.StudentDao connectionStudentDao;
	@Autowired
	private org.redborn.csatlatte.persistence.student.SecurityQuestionDao studentSecurityQuestionDao;
	@Autowired
	private SecurityQuestionDao securityQuestionDao;
	@Autowired
	private YearStudentDao yearStudentDao;
	@Autowired
	private PlatformTransactionManager transactionManager;
	@Autowired
	private CsatAmazonS3 csatAmazonS3;
	
	public boolean checkPassword(int studentSequence, String password) {
		logger.info("Business layer student checkPassword.");
		return studentDao.selectOneCountPassword(studentSequence, makePassword(studentSequence, password)) == 1;
	}
	
	public boolean changePassword(int studentSequence, String password, String newPassword) {
		logger.info("Business layer student changePassword.");
		boolean result = false;
		if (studentDao.selectOneCountPassword(studentSequence, makePassword(studentSequence, password)) == 1 
				&& studentDao.updatePassword(studentSequence, makePassword(studentSequence, newPassword)) == 1) {
			result = true;
		}
		return result;
	}

	public boolean changePassword(String studentId, String securityAnswer,
			String newPassword) {
		logger.info("Business layer student checkPassword.");
		boolean result = false;
		if (isPassword(studentId, securityAnswer)) {
			int studentSequence = getStudentSequence(studentId);
			if (studentDao.updatePassword(studentSequence, makePassword(studentSequence, newPassword)) == 1) {
				result = true;
			}
		}
		return result;
	}

	public boolean changeInformation(StudentVo studentVo, File photo, boolean photoDelete) {
		logger.info("Business layer student changeInformation.");
		StudentVo beforeStudentVo = studentDao.selectOneDetail(studentVo.getStudentSequence());
		
		if (photo != null) {
			studentVo.setPhotoName(photo.getName());
			studentVo.setPhotoCode(csatAmazonS3.upload(photo, CsatAmazonS3Prefix.STUDENT_PROFILE));
			photo.delete();
			csatAmazonS3.delete(CsatAmazonS3Prefix.STUDENT_PROFILE, beforeStudentVo.getPhotoCode());
		} else {
			if (photoDelete) {
				studentVo.setPhotoCode(null);
				studentVo.setPhotoName(null);
				csatAmazonS3.delete(CsatAmazonS3Prefix.STUDENT_PROFILE, beforeStudentVo.getPhotoCode());
			} else {
				studentVo.setPhotoCode(beforeStudentVo.getPhotoCode());
				studentVo.setPhotoName(beforeStudentVo.getPhotoName());
			}
		}
		
		return studentDao.updateInformation(studentVo) == 1;
	}

	public boolean changeSecurity(StudentSecurityQuestionVo studentSecurityQuestionVo) {
		logger.info("Business layer student changeSecurity.");
		return studentSecurityQuestionDao.updateContent(studentSecurityQuestionVo) == 1;
	}

	public boolean join(StudentVo studentVo, StudentSecurityQuestionVo studentSecurityQuestionVo, File photo) {
		logger.info("Business layer student join.");
		boolean result = false;
		int maxStudentSequence = studentDao.selectOneMaxStudentSequence();
		studentVo.setStudentSequence(maxStudentSequence);
		Date createDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		studentVo.setCreateDate(simpleDateFormat.format(createDate));
		
		simpleDateFormat.applyPattern("HHmmssSSS");
		
		studentVo.setStudentPassword(new StringBuilder(simpleDateFormat.format(createDate)).append(studentVo.getStudentPassword()).toString());
		
		if (photo != null) {
			studentVo.setPhotoName(photo.getName());
			studentVo.setPhotoCode(csatAmazonS3.upload(photo, CsatAmazonS3Prefix.STUDENT_PROFILE));
			photo.delete();
		}
		
		studentSecurityQuestionVo.setStudentSequence(maxStudentSequence);
		DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
		defaultTransactionDefinition.setName("student join transaction");
		defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus transactionStatus = transactionManager.getTransaction(defaultTransactionDefinition);
		
		try {
			if (studentDao.insert(studentVo) == 1 && studentSecurityQuestionDao.insert(studentSecurityQuestionVo) == 1) {
				result = true;
				transactionManager.commit(transactionStatus);
				logger.info(new StringBuilder("Business layer student join success. transaction rollback. Student id is ").append(studentVo.getStudentId()).toString());
			} else {
				transactionManager.rollback(transactionStatus);
				logger.warn(new StringBuilder("Business layer student join fail. transaction rollback. Student id is ").append(studentVo.getStudentId()).toString());
			}
		} catch (RuntimeException e) {
			transactionManager.rollback(transactionStatus);
			logger.warn(new StringBuilder("Business layer student join exception. transaction rollback. Student id is ").append(studentVo.getStudentId()).toString());
		}
		
		return result;
	}

	public String findId(String nickname, String securityAnswer) {
		logger.info("Business layer student findId.");
		return studentDao.selectOneId(nickname, securityAnswer);
	}

	public boolean isPassword(String id, String securityAnswer) {
		logger.info("Business layer student isPassword.");
		return studentDao.selectOneCountIsPassword(id, securityAnswer) == 1;
	}
	
	public boolean isId(String studentId) {
		logger.info("Business layer student isId.");
		boolean result = true;
		if (studentDao.selectOneCountOverlapId(studentId) != 1) {
			Set<String> url = new HashSet<String>();
			url.add("main");
			url.add("rating");
			url.add("grade");
			url.add("community");
			url.add("support");
			url.add("profile");
			url.add("join");
			url.add("id");
			url.add("password");
			url.add("data");
			url.add("file");
			url.add("login");
			url.add("manage");
			url.add("stats");
			url.add("error");
			url.add("university");
			url.add("college");
			url.add("chart");
			url.add("news");
			url.add("column");
			url.add("information");
			url.add("major");
			url.add("event");
			url.add("notice");
			url.add("ad");
			url.add("aptitude");
			url.add("map");
			if (!url.contains(studentId)) {
				result = false;
			}
		}
		return result;
	}
	
	public boolean isNickname(String nickname) {
		logger.info("Business layer student isNickname.");
		return studentDao.selectOneCountOverlapNickname(nickname) == 1;
	}

	public StudentVo information(String id, String password) {
		logger.info("Business layer student information.");
		return studentDao.selectOne(id, makePassword(id, password));
	}
	
	public StudentVo information(int studentSequence) {
		logger.info("Business layer student information.");
		return studentDao.selectOneDetail(studentSequence);
	}

	public boolean connection(int studentSequence, String userAgent,
			String sessionId, String ip) {
		logger.info("Business layer student connection.");
		return connectionStudentDao.insert(studentSequence, userAgent, sessionId, ip) == 1;
	}

	public boolean lock(int studentSequence) {
		logger.info("Business layer student lock.");
		return studentDao.updateUseYnN(studentSequence) == 1;
	}
	
	public boolean unlock(int studentSequence) {
		logger.info("Business layer student unlock.");
		return studentDao.updateUseYnNRecovery(studentSequence) == 1;
	}
	
	/**
	 * 통계 배열을 만들어줍니다.
	 * 
	 * @param connectionYmdCountVos 연결 수 배열
	 * @param begin 시작 날짜
	 * @param end 마지막 날짜
	 * @return 통계 배열
	 */
	private List<CountVo> makeCountVoList(List<CountVo> YmdCountVos, int begin, int end) {
		logger.info("Business layer student margeCountVoList.");
		List<CountVo> ymdCountVos = new ArrayList<CountVo>();
		
		int YmdCountVosIndex = 0;
		int YmdCountVossSize = YmdCountVos != null ? YmdCountVos.size() : 0;
		
		for (int index = begin; index <= end; index++) {
			CountVo ymdCountVo = new CountVo();
			
			int sumCount = 0;
			
			if (YmdCountVosIndex < YmdCountVossSize) {
				CountVo connectionCountVo = YmdCountVos.get(YmdCountVosIndex);
				if (connectionCountVo.getKey() == index) {
					sumCount = connectionCountVo.getCount();
					YmdCountVosIndex++;
				}
			}
			
			ymdCountVo.setKey(index);
			ymdCountVo.setCount(sumCount);
			
			ymdCountVos.add(ymdCountVo);
		}
		
		return ymdCountVos;
	}

	public List<CountVo> dailyJoinCountList(String ymd) {
		logger.info("Business layer student dailyJoinCountList.");
		return makeCountVoList(studentDao.selectListCountYmd(ymd), 0, 23);
	}

	public List<CountVo> monthlyJoinCountList(String ym) {
		logger.info("Business layer student monthlyJoinCountList.");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(ym.substring(0, 4)), Integer.parseInt(ym.substring(5, 6)) - 1, 1);
		return makeCountVoList(studentDao.selectListCountYm(ym), 1, calendar.getActualMaximum(Calendar.DATE));
	}

	public List<CountVo> annualJoinCountList(String year) {
		logger.info("Business layer student annualJoinCountList.");
		return makeCountVoList(studentDao.selectListCountYear(year), 1, 12);
	}

	public List<CountVo> dailyConnectionCount(String ymd) {
		logger.info("Business layer student dailyConnectionCount.");
		return makeCountVoList(connectionStudentDao.selectListCountYmd(ymd), 0, 23);
	}

	public List<CountVo> monthlyConnectionCount(String ym) {
		logger.info("Business layer student monthlyConnectionCount.");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(ym.substring(0, 4)), Integer.parseInt(ym.substring(5, 6)) - 1, 1);
		return makeCountVoList(connectionStudentDao.selectListCountYm(ym), 1, calendar.getActualMaximum(Calendar.DATE));
	}

	public List<CountVo> annualConnectionCount(String year) {
		logger.info("Business layer student annualConnectionCount.");
		return makeCountVoList(connectionStudentDao.selectListCountYear(year), 1, 12);
	}

	public List<StudentVo> userList(String search, int pageNumber) {
		logger.info("Business layer student userList.");
		return studentDao.selectList(search, pageNumber);
	}

	public String securityQuestion(String nickname) {
		logger.info("Business layer student securityQuestion.");
		return securityQuestion(studentDao.selectOneStudentSequence(nickname));
	}

	public String securityQuestion(int studentSequence) {
		logger.info("Business layer student securityQuestion.");
		return securityQuestionDao.selectOne(studentSequence);
	}
	
	public int amountStudent(String search) {
		logger.info("Business layer student amountStudent.");
		return studentDao.selectOneCount(search);
	}
	
	public List<YearStudentVo> yearStudentList() {
		logger.info("Business layer student yearStudentList.");
		return yearStudentDao.selectList();
	}
	
	/**
	 * 비밀번호를 만듭니다.
	 * 
	 * @param studentId 학생 ID
	 * @param password 비밀번호
	 * @return 생성된 비밀번호
	 */
	private String makePassword(String studentId, String password) {
		logger.info("Business layer student makePassword.");
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
		logger.info("Business layer student makePassword.");
		String hmsm = studentDao.selectOneCreateHmsmWhereStudentSequence(studentSequence);
		if (hmsm == null) {
			hmsm = "";
		}
		return new StringBuilder(hmsm).append(password).toString();
	}
	
	public List<SecurityQuestionVo> securityQuestionList() {
		logger.info("Business layer student securityQuestionList.");
		return securityQuestionDao.selectList();
	}
	
	public int getStudentSequence(String studentId) {
		logger.info("Business layer student getStudentSequence.");
		return studentDao.selectOneStudentSequenceById(studentId);
	}

	public String getPhotoName(int studentSequence) {
		logger.info("Business layer student getPhotoName.");
		return studentDao.selectPhotoName(studentSequence);
	}
	
	public InputStream getInputStream(int studentSequence) {
		logger.info("Business layer student InputStream.");
		return csatAmazonS3.getInputStream(CsatAmazonS3Prefix.STUDENT_PROFILE, studentDao.selectPhotoCode(studentSequence));
	}

}

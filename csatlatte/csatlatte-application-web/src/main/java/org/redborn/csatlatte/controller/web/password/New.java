package org.redborn.csatlatte.controller.web.password;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 비밀번호 찾기에서 새 비밀번호를 설정하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/password/new")
public class New {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;

	/**
	 * 기존 비밀번호, 새 비밀번호를 입력하는 페이지입니다.
	 * 
	 * 입력한 값에 이상이 없는 경우 비밀번호 변경 처리 후 비밀번호 찾기 완료 페이지(TilesName.PASSWORD_NEW_SUCCESS)를 출력합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="studentId",required=true) String studentId,
			@RequestParam(value="securityAnswer",required=true) String securityAnswer,
			@RequestParam(value="newPassword",required=true) String newPassword) {
		logger.info("find password success");
		
		String result = TilesName.PASSWORD_NEW_FAIL;
		
		if (studentService.isPassword(studentId, securityAnswer)) {
			int studentSequence = studentService.studentIdStudentSequence(studentId);
			studentService.changePasswordForFind(studentSequence, newPassword);
			result = TilesName.PASSWORD_NEW_SUCCESS;
		}
		
		return result;
	}
}

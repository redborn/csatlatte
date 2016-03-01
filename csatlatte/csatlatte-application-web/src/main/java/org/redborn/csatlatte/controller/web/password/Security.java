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
 * 비밀번호 찾기 보안확인입니다.  
 */
@Controller
@RequestMapping("/password/security")
public class Security {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;

	/**
	 * 비밀번호 찾기 보안확인 인증입니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="securityAnswer",required=true) String securityAnswer,
			@RequestParam(value="studentId",required=true) String studentId) {
		logger.info("find password new");

		String result = TilesName.PASSWORD_SECURITY_FAIL;
		if (studentService.isPassword(studentId, securityAnswer)) {
			result = TilesName.PASSWORD_NEW_WRITE;
		}
		
		return result;
	}
}

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
 * 비밀번호 찾기 새 비밀번호 설정입니다.
 */
@Controller
@RequestMapping("/password/new")
public class New {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;

	/**
	 * 새 비밀번호 처리입니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="studentId",required=true) String studentId,
			@RequestParam(value="securityAnswer",required=true) String securityAnswer,
			@RequestParam(value="newPassword",required=true) String newPassword) {
		logger.info("Controller password new POST.");
		
		String result = TilesName.PASSWORD_NEW_FAIL;
		if (studentService.changePassword(studentId, securityAnswer, newPassword)) {
			result = TilesName.PASSWORD_NEW_SUCCESS;
		}
		
		return result;
	}
}

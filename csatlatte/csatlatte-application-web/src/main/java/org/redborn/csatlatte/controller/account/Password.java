package org.redborn.csatlatte.controller.account;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 사용자 비밀번호 변경입니다.
 */
@Controller
@RequestMapping("/{id}/password")
public class Password {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpSessionValue httpSessionValue;

	/**
	 * 기존 비밀번호, 새 비밀번호를 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("Controller account password GET.");
		return TilesName.PROFILE_PASSWORD_WRITE;
	}

	/**
	 * 비밀번호 변경 처리 영역입니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="beforePassword",required=true) String beforePassword,
			@RequestParam(value="newPassword",required=true) String newPassword,
			@RequestParam(value="newPasswordCheck",required=true) String newPasswordCheck) {
		logger.info("Controller account password POST.");
		String result = TilesName.PROFILE_PASSWORD_FAIL;
		if (newPassword.equals(newPasswordCheck)) {
			if (studentService.changePassword(httpSessionValue.getStudentSequence(), beforePassword, newPassword)) {
				result = TilesName.PROFILE_PASSWORD_SUCCESS;
			}
		}
		return result;
	}

}
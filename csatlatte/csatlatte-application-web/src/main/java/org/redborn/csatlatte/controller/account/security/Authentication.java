package org.redborn.csatlatte.controller.account.security;

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
 * 비밀번호 인증입니다.
 */
@Controller
@RequestMapping("/{id}/security/authentication")
public class Authentication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private HttpSessionValue httpSessionValue;
	@Autowired
	private StudentService studentService;

	/**
	 * 비밀번호를 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("Controller account security authentication GET.");
		return TilesName.PROFILE_SECURITY_AUTHENTICATION_WRITE;
	}
	
	/**
	 * 비밀번호 인증을 처리 합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(Model model, @RequestParam(value="password",required=true) String password) {
		logger.info("Controller account security authentication POST.");
		String result = TilesName.PROFILE_SECURITY_AUTHENTICATION_FAIL;
		if (studentService.checkPassword(httpSessionValue.getStudentSequence(), password)) {
			model.addAttribute("securityQuestionList", studentService.securityQuestionList());
			result = TilesName.PROFILE_SECURITY_WRITE;
		}
		return result;
	}
}
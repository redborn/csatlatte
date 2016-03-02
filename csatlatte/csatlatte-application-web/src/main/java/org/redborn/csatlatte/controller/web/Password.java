package org.redborn.csatlatte.controller.web;

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
 * 비밀번호 찾기입니다.
 */
@Controller
@RequestMapping("/password")
public class Password {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;

	/**
	 * 비밀번호 찾기 아이디 입력 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("Controller password GET.");
		return TilesName.PASSWORD_WRITE;
	}

	/**
	 * 비밀번호 찾기 아이디 검사 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(Model model, @RequestParam(value="studentId",required=true) String studentId) {
		logger.info("Controller password POST.");
		
		String result = TilesName.PASSWORD_FAIL;
		if (studentService.isId(studentId)) {
			model.addAttribute("securityQuestion", studentService.securityQuestion(studentService.getStudentSequence(studentId)));
			result = TilesName.PASSWORD_SECURITY_WRITE;
		}
		
		return result;
	}
}

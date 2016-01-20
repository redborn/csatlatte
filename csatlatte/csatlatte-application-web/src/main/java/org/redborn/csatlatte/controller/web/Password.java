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
 * 분실한 비밀번호를 재설정할 수 있는 controller 입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/password")
public class Password {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;

	/**
	 * 비밀번호를 재설정할 아이디를 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("find password view");
		return TilesName.PASSWORD_WRITE;
	}

	/**
	 * 입력한 아이디가 DB상에 존재여부를 판단하는 영역입니다.
	 * 
	 * 입력한 아이디가 존재하는 경우 비밀번호 찾기 보안확인 페이지(TilesName.PASSWORD_SECURITY_WRITE)로 이동합니다.
	 * 
	 * 입력한 아이디가 존재하지 않는 경우 아이디 입력 실패 페이지(TilesName.PASSWORD_FAIL)를 출력합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(Model model, @RequestParam(value="studentId",required=true) String studentId) {
		logger.info("find password id");
		
		boolean success = studentService.overlapCheckId(studentId);
		
		String result = TilesName.PASSWORD_FAIL;
		if (success) {
			model.addAttribute("securityQuestion", studentService.securityQuestion(studentService.getStudentSequence(studentId)));
			result = TilesName.PASSWORD_SECURITY_WRITE;
		}
		
		return result;
	}
}

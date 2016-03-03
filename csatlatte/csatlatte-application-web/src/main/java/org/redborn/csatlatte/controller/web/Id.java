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
 * 아이디 찾기입니다.
 */
@Controller
@RequestMapping("/id")
public class Id {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 아이디 찾기입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("Controller id GET.");
		return TilesName.ID_WRITE;
	}

	/**
	 * 닉네임 존재 여부 확인입니다. 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(Model model, @RequestParam(value="nickname",required=true) String nickname) {
		logger.info("Controller id POST.");
		
		String result = TilesName.ID_FAIL;
		if (studentService.isNickname(nickname)) {
			model.addAttribute("securityQuestion", studentService.securityQuestion(nickname));
			result = TilesName.ID_SECURITY_WRITE;
		}
		return result;
	}
	
}
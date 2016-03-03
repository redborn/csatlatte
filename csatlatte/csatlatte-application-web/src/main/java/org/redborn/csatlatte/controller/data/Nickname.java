package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 닉네임 관련 기능입니다.
 */
@Controller
@RequestMapping("/data/nickname")
public class Nickname {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 닉네임 중복검사입니다.
	 * 
	 * @param model
	 * @param nickname 닉네임
	 */
	@RequestMapping(value="{nickname}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="nickname") String nickname) {
		logger.info("Controller data nickname GET.");
		model.addAttribute("isNickname", studentService.isNickname(nickname));
	}
	
}

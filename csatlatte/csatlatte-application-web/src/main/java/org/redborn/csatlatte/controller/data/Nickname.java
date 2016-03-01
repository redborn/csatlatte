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
 * 닉네임에 관련한 기능을 수행하는 data controller입니다.
 */
@Controller
@RequestMapping("/data/nickname")
public class Nickname {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 닉네임 존재 여부(중복)를 조회하는 method입니다.
	 * @param model
	 * @param nickname 중복 검사할 닉네임 값입니다.
	 */
	@RequestMapping(value="{nickname}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="nickname") String nickname) {
		logger.info("data nickname view");
		model.addAttribute("isNickname", studentService.isNickname(nickname));
	}
	
}

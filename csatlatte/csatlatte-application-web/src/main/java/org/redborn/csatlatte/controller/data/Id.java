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
 * 아이디에 관련한 기능을 수행하는 data controller입니다.
 */
@Controller
@RequestMapping("/data/id")
public class Id {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 아이디 존재 여부(중복)를 조회하는 method입니다.
	 * @param model
	 * @param studentId 중복 검사할 아이디 값입니다.
	 */
	@RequestMapping(value="{studentId}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="studentId") String studentId) {
		logger.info("data id view");
		model.addAttribute("isId", studentService.isId(studentId));
	}
}

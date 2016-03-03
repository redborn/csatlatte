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
 * 사용자 관련 기능입니다.
 */
@Controller
@RequestMapping("/data/student")
public class Student {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 사용자 상세정보 조회입니다.
	 * 
	 * @param model
	 * @param studentSequence 학생 일련번호
	 */
	@RequestMapping(value="{studentSequence}",method=RequestMethod.GET)
	public void detail(Model model, @PathVariable(value="studentSequence") int studentSequence) {
		logger.info("Controller data student GET.");
		
		model.addAttribute("information", studentService.information(studentSequence));
	}
	
}

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
 * 사용자(학생)에 대한 data controller입니다.
 */
@Controller
@RequestMapping("/data/student")
public class Student {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 특정 사용자의 상세정보를 조회하는 method입니다.
	 * @param model
	 * @param studentSequence 조회하고자 하는 사용자의 번호입니다.
	 */
	@RequestMapping(value="{studentSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="studentSequence") int studentSequence) {
		logger.info("data manage student view");
		
		model.addAttribute("information", studentService.information(studentSequence));
	}
	
}

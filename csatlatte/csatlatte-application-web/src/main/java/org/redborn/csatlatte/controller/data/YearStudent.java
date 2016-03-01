package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 학년에 대한 data controller입니다.
 */
@Controller
@RequestMapping("/data/yearstudent")
public class YearStudent {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 학년 목록을 조회하는 method입니다.
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model) {
		logger.info("data yearStudentList get view");
		
		model.addAttribute("yearStudentList", studentService.yearStudentList());
	}
}

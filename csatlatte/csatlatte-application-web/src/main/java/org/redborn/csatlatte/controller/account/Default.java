package org.redborn.csatlatte.controller.account;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.ExamService;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자 정보입니다.
 */
@Controller
@RequestMapping("/{id}")
public class Default {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired 
	private StudentService studentService;
	@Autowired
	private ExamService examService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 사용자 정보입니다.
	 * 
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("Controller account default GET.");
		model.addAttribute("csat", examService.getCsat(httpSessionValue.getCsatSequence()));
		model.addAttribute("securityQuestion", studentService.securityQuestion(httpSessionValue.getStudentSequence()));
		return TilesName.PROFILE;
	}

}

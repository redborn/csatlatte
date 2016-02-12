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
	
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("account default view");
		int studentSequence = httpSessionValue.getStudentSequence();
		int csatSequence = httpSessionValue.getCsatSequence();
		model.addAttribute("csat", examService.csat(csatSequence));
		model.addAttribute("securityQuestion", studentService.securityQuestion(studentSequence));
		return TilesName.PROFILE;
	}

}
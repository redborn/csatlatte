package org.redborn.csatlatte.controller.data.student.connection.stats;

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
 * 연간 접속자 통계입니다.
 */
@Controller
@RequestMapping("/data/student/connection/stats/annual")
public class Annual {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 연간 접속자 통계입니다.
	 * 
	 * @param model
	 * @param year 연도입니다.
	 */
	@RequestMapping(value="{year}", method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="year") String year) {
		logger.info("data stats annualconnection view");
		
		model.addAttribute("annualConnection", studentService.annualConnectionCount(year));
	}
}

package org.redborn.csatlatte.controller.account.data.grade;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.service.GradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 표준점수 성적 분석입니다.
 */
@Controller
@RequestMapping("/{id}/data/grade/standardscore")
public class StandardScore {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private GradeService gradeService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 표준점수 성적 분석입니다.
	 * 
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model) {
		logger.info("Controller data grade standardscore GET.");
		model.addAttribute("list", gradeService.standardScoreList(httpSessionValue.getCsatSequence(), httpSessionValue.getStudentSequence()));
	}

}

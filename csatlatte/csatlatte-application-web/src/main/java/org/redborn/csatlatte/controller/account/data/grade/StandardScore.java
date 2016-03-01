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
 * 사용자의 모의고사 표준점수에 대한 분석을 위한 data controller 영역입니다.
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
	 * 사용자가 등록한 성적의 모의고사 표준점수 목록을 조회하는 method 입니다.
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model) {
		logger.info("Controller data grade.");
		model.addAttribute("list", gradeService.standardScoreList(httpSessionValue.getCsatSequence(), httpSessionValue.getStudentSequence()));
	}

}

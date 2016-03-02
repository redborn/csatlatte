package org.redborn.csatlatte.controller.data.rating;

import org.redborn.csatlatte.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 모의고사 등급컷 시험정보입니다.
 */
@Controller
@RequestMapping("/data/rating/exam")
public class Exam {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	/**
	 * 모의고사 등급컷 연도 목록입니다.
	 * 
	 * @param model
	 * @param yearStudentSequence 학년 일련번호
	 */
	@RequestMapping(value="{yearStudentSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="yearStudentSequence") int yearStudentSequence) {
		logger.info("Controller data rating exam GET.");
		model.addAttribute("yearList", examService.yearList(yearStudentSequence));
	}
	
	/**
	 * 모의고사 등급컷 목록입니다.
	 * 
	 * @param model
	 * @param yearStudentSequence 학년 일련번호
	 * @param year 연도
	 */
	@RequestMapping(value="{yearStudentSequence}/{year}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="yearStudentSequence") int yearStudentSequence,
			@PathVariable(value="year") String year) {
		logger.info("Controller data rating exam GET.");
		model.addAttribute("list", examService.list(year, yearStudentSequence));
	}
	
}

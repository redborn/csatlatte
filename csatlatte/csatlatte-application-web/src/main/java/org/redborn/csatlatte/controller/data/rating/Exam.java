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
 * 모의고사 등급컷 조회에 필요한 목록들에 대한 data controller입니다.
 */
@Controller
@RequestMapping("/data/rating/exam")
public class Exam {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	/**
	 * 특정 학년에 해당하는 시험의 연도 목록을 조회하는 method입니다.
	 * @param model
	 * @param yearStudentSequence 학년 번호입니다.
	 */
	@RequestMapping(value="{yearStudentSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="yearStudentSequence") int yearStudentSequence) {
		logger.info("data rating exam get view");
		model.addAttribute("yearList", examService.yearList(yearStudentSequence));
	}
	
	/**
	 * 특정 학년과 연도에 해당하는 모의고사 목록을 조회하는 method입니다.
	 * @param model
	 * @param yearStudentSequence 학년 번호입니다.
	 * @param year 연도 값입니다.
	 */
	@RequestMapping(value="{yearStudentSequence}/{year}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="yearStudentSequence") int yearStudentSequence,
			@PathVariable(value="year") String year) {
		logger.info("data rating exam get view");
		model.addAttribute("list", examService.list(year, yearStudentSequence));
	}
	
}

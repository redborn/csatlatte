package org.redborn.csatlatte.controller.data.solving;

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
 * 모의고사 풀이 시험 리스트 입니다.
 *
 */
@Controller
@RequestMapping("/data/solving/exam")
public class Exam {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	/**
	 * 학년 및 연도에 해당하는 모의고사 목록 입니다.
	 * 
	 * @param model
	 * @param yearStudentSequence 학년 일련번호
	 * @param year 연도
	 */
	@RequestMapping(value="{yearStudentSequence}/{year}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="yearStudentSequence") int yearStudentSequence, @PathVariable(value="year") String year) {
		logger.info("Controller data solving exam GET.");
		System.out.println(year);
		model.addAttribute("list", examService.listForSolving(year, yearStudentSequence));
	}

}
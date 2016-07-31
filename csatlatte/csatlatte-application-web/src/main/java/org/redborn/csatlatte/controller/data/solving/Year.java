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
 * 모의고사 풀이 연도 목록 입니다.
 *
 */
@Controller
@RequestMapping("/data/solving/year")
public class Year {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	/**
	 * 학년에 해당하는 모의고사 풀이 연도 목록 입니다.
	 * 
	 * @param model
	 * @param yearStudentSequence 학년 일련번호
	 */
	@RequestMapping(value="{yearStudentSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="yearStudentSequence") int yearStudentSequence) {
		logger.info("Controller data solving year GET.");
		model.addAttribute("list", examService.yearListForSolving(yearStudentSequence));
	}

}
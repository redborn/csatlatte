package org.redborn.csatlatte.controller.data.exam;

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
 * 시험의 평균입니다.
 */
@Controller
@RequestMapping("/data/exam/average")
public class Average {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	/**
	 * 시험의 평균 목록입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 모의고사 일련번호
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("Controller data exam average GET.");
		model.addAttribute("averageList", examService.averageList(csatSequence, examSequence));
	}
}

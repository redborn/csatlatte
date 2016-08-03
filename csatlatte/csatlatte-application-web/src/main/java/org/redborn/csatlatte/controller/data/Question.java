package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 모의고사 문제입니다.
 */
@Controller
@RequestMapping("/data/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QuestionService questionService;
	
	/**
	 * 모의고사 문제 목록입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("Controller data question GET.");
		model.addAttribute("list", questionService.list(csatSequence, examSequence));
	}
	
	/**
	 * 모의고사 문제 삭제입니다.
	 * 
	 * @param model
	 * @param csatSequence 수능 일련번호
	 * @param examSequence 시험 일련번호
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.DELETE)
	public void delete(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("Controller data question DELETE.");
		model.addAttribute("result", questionService.delete(csatSequence, examSequence));
	}
	
}

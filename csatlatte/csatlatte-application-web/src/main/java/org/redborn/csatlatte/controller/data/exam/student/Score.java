package org.redborn.csatlatte.controller.data.exam.student;

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
 * 시험의 학생 등록 점수에 대한 data controller 영역입니다.
 */
@Controller
@RequestMapping("/data/exam/student/score")
public class Score {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	/**
	 * 특정 시험의 학생 등록 점수 목록을 조회하는 method입니다.
	 * @param model
	 * @param csatSequence 시험의 수능 번호입니다.
	 * @param examSequence 시험의 번호입니다.
	 */
	@RequestMapping(value="{csatSequence}/{examSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="csatSequence") int csatSequence,
			@PathVariable(value="examSequence") int examSequence) {
		logger.info("data exam studentscore get view");
		model.addAttribute("examStudentList", examService.examStudentList(csatSequence, examSequence));
	}
	
}

package org.redborn.csatlatte.controller.data.student.join.stats;

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
 * 월간 가입자 통계에 대한 data controller 영역입니다.
 */
@Controller
@RequestMapping("/data/student/join/stats/monthly")
public class Monthly {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 특정 월의 가입자 수치를 조회하는 method입니다.
	 * @param model
	 * @param ym 조회하고자 하는 월 값입니다.
	 */
	@RequestMapping(value="{ym}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="ym") String ym) {
		logger.info("data stats monthlyjoin view");
		
		model.addAttribute("monthlyJoin", studentService.monthlyJoinCountList(ym));
	}
}

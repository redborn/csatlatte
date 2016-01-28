package org.redborn.csatlatte.controller.web;

import java.util.Calendar;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.service.ExamService;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자가 직접 입력을 통해 사용자 본인의 성적을 관리하는 controller 입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/grade")
public class Grade {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private HttpSessionValue httpSessionValue;
	@Autowired
	private ExamService examService;
	@Autowired
	private StudentService studentService;
	
	/** 
	 * 사용자의 성적을 조회, 입력, 삭제, 수정을 하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("grade view");
		String result = TilesName.GRADE;
		
		if (httpSessionValue.getStudentSequence() != 0) {
			CsatVo csatVo = examService.getCsat(httpSessionValue.getCsatSequence());
			if (csatVo != null) {
				String examYmd = csatVo.getExamYmd();
				int yearStudentSequence = 3;
				if (examYmd != null && examYmd.length() >= 4) {
					int gap = Integer.parseInt(examYmd.substring(0, 4)) - Calendar.getInstance().get(Calendar.YEAR);
					if (gap > 0) {
						yearStudentSequence = 4 - gap;
					}
				}
				model.addAttribute("yearStudentList", studentService.yearStudentList());
				model.addAttribute("yearStudentSequence", yearStudentSequence);
			}
		} else {
			result = TilesName.GRADE_GUEST;
		}
		return result;
	}
	
}

package org.redborn.csatlatte.controller.web.manage;

import java.util.Calendar;
import java.util.List;

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
 * 모의고사 관리입니다.
 */
@Controller
@RequestMapping("/manage/exam")
public class Exam {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	@Autowired
	private StudentService studentService;
	
	/**
	 * 모의고사 목록입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("Controller manage exam GET.");
		
		List<CsatVo> csatList = examService.csatList();
		int presentCsatSequence = 0;
		
		Calendar calendar = Calendar.getInstance();
		int presentYear = calendar.get(Calendar.YEAR); 
		
		if (csatList != null) {
			int csatListSize = csatList.size();
			for (int index = 0; index < csatListSize; index++) {
				CsatVo csatVo = csatList.get(index);
				String examYmd = csatVo.getExamYmd();
				if (examYmd != null && examYmd.length() >= 4) {
					if (Integer.parseInt(examYmd.substring(0, 4)) == presentYear) {
						presentCsatSequence = csatVo.getCsatSequence();
						break;
					}
				}
			}
		}
		
		model.addAttribute("csatList", csatList);
		model.addAttribute("presentCsatSequence", presentCsatSequence);
		
		return TilesName.MANAGE_EXAM;
	}
}

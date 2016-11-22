package org.redborn.csatlatte.controller.web;

import java.util.Calendar;
import java.util.List;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 메인페이지입니다.
 */
@Controller
@RequestMapping({"/main", "/"})
public class Main {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 메인페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("Controller main GET.");
		
		List<CsatVo> csatList = examService.csatList();
		int presentCsatSequence = 0;
		int studentCsatSequence = httpSessionValue.getCsatSequence();
		
		Calendar calendar = Calendar.getInstance();
		int presentYear = calendar.get(Calendar.YEAR);
		if (studentCsatSequence == 0) {
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
			model.addAttribute("dDay", examService.examDday(presentCsatSequence));
		} else {
			model.addAttribute("dDay", examService.examDday(studentCsatSequence));
		}
		
		return TilesName.MAIN;
	}
}
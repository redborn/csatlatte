package org.redborn.csatlatte.controller.web.manage;

import java.text.SimpleDateFormat;
import java.util.Date;
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
 * 새 모의고사를 작성하거나 기존 모의고사의 정보를 수정하는 controller입니다.
 * 
 * @author 최순현
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
	 * 모의고사 목록을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("manage exam view");
		
		List<CsatVo> csatList = examService.csatList();
		int csatListSize = csatList.size();
		int year = 0;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String presentYear = format.format(date);
		
		for (int index = 0; index < csatListSize; index++) {
			if (csatList.get(index).getExamYmd().substring(0, 4).equals(presentYear)) {
				year = csatList.get(index).getCsatSequence();
			}
		}
		
		model.addAttribute("csatList", csatList);
		model.addAttribute("year", year);
		
		return TilesName.MANAGE_EXAM;
	}
}

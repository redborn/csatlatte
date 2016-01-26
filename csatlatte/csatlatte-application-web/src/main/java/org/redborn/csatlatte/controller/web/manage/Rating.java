package org.redborn.csatlatte.controller.web.manage;

import java.util.Calendar;
import java.util.List;

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

@Controller
@RequestMapping("/manage/rating")
public class Rating {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("manage rating get view");
		
		List<CsatVo> csatList = examService.csatList();
		int csatListSize = csatList.size();
		int year = 0;
		
		Calendar calendar = Calendar.getInstance();
		int presentYear = calendar.get(Calendar.YEAR);
		String presentYearString = Integer.toString(presentYear);
		
		for (int index = 0; index < csatListSize; index++) {
			if (csatList.get(index).getExamYmd().substring(0, 4).equals(presentYearString)) {
				year = csatList.get(index).getCsatSequence();
			}
		}
		
		model.addAttribute("csatList", csatList);
		model.addAttribute("year", year);
		
		return TilesName.MANAGE_RATING;
	}
}

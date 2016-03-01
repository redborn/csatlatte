package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 주관 교육청입니다.
 */
@Controller
@RequestMapping("/data/institution")
public class Institution {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	/**
	 * 주관 교육청 목록입니다.
	 * 
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model) {
		logger.info("data institutionList get view");
		
		model.addAttribute("institutionList", examService.institutionList());
	}
}

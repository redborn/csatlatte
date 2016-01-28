package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data/section")
public class Section {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value="{csatSequence}/{examSequence}")
	public void get(Model model, @PathVariable(value="csatSequence") int csatSequence, @PathVariable(value="examSequence") int examSequence) {
		logger.info("data section list");
		model.addAttribute("list", examService.sectionList(csatSequence, examSequence));
	}

}
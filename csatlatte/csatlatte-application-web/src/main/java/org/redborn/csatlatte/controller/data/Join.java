package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/join")
public class Join {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="overlapValue",required=true) String overlapValue,
			@RequestParam(value="item",required=true) int item) {
		logger.info("data join view");
		
		switch(item) {
		case 1:
			model.addAttribute("overlapCheckId", studentService.isId(overlapValue));
			break;
		case 2:
			model.addAttribute("overlapCheckNickname", studentService.isNickname(overlapValue));
			break;
		}
	}
}

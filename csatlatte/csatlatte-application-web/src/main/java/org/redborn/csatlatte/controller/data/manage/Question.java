package org.redborn.csatlatte.controller.data.manage;

import org.redborn.csatlatte.service.QnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/manage/question")
public class Question {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="search",required=false,defaultValue="") String search,
			@RequestParam(value="pageNumber",required=false,defaultValue="1") int pageNumber,
			@RequestParam(value="useYn",required=false,defaultValue="") String useYn) {
		logger.info("data manage question view");
		
		int beginPageNumber = (pageNumber * 10) - 10;
		
		model.addAttribute("list", qnaService.listForManage(search, beginPageNumber, useYn));
	}
}

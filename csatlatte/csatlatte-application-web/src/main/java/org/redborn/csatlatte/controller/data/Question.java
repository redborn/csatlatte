package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.service.QnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/data/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	@Autowired
    private HttpSessionValue httpSessionValue;
	
	@RequestMapping(value="{qnaSequence}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="qnaSequence") int qnaSequence) {
		logger.info("data question view");
		model.addAttribute("detail", qnaService.detail(qnaSequence));
		model.addAttribute("files", qnaService.fileList(qnaSequence));
	}
	
	@RequestMapping(value="{qnaSequence}",method=RequestMethod.DELETE)
	public void delete(@PathVariable(value="qnaSequence") int qnaSequence) {
		logger.info("data question delete");
		qnaService.delete(qnaSequence);
	}

}

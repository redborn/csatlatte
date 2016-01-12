package org.redborn.csatlatte.controller.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.domain.QnaVo;
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
@RequestMapping("/data/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	@Autowired
    private HttpSessionValue httpSessionValue;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="qnaSequence",required=true) int qnaSequence) {
		logger.info("data question view");
		
		model.addAttribute("detail", qnaService.detail(qnaSequence));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void post(@RequestParam(value="title",required=true) String title,
			@RequestParam(value="content",required=true) String content) {
		logger.info("data question insert");
		
		QnaVo qnaVo = new QnaVo();
		List<File> listFile = new ArrayList<File>(); // File 관련 교육 후 구현 진행
		
		qnaVo.setTitle(title);
		qnaVo.setContent(content);
		qnaVo.setStudentSequence(httpSessionValue.getStudentSequence());
		
		qnaService.write(qnaVo, listFile);
		
	}

}

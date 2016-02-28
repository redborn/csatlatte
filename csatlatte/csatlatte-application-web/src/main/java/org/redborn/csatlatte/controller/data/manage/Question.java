package org.redborn.csatlatte.controller.data.manage;

import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.redborn.csatlatte.service.QnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/manage/question")
public class Question {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="{qnaSequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="qnaSequence") int qnaSequence, 
			@RequestParam(value="answerContent",required=true) String answerContent) {
		logger.info("data manage question post insert");
		
		QnaAnswerVo qnaAnswerVo = new QnaAnswerVo();
		
		qnaAnswerVo.setQnaSequence(qnaSequence);
		qnaAnswerVo.setContent(answerContent);
		model.addAttribute("result", qnaService.answer(qnaAnswerVo));
	}
}

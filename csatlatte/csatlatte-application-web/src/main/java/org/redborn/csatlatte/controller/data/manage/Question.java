package org.redborn.csatlatte.controller.data.manage;

import org.redborn.csatlatte.domain.QnaAnswerVo;
import org.redborn.csatlatte.service.QnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/manage/question")
public class Question {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void post(@RequestParam(value="answerContent",required=true) String answerContent,
			@RequestParam(value="qnaSequence",required=true) int qnaSequence) {
		logger.info("data manage question post insert");
		
		QnaAnswerVo qnaAnswerVo = new QnaAnswerVo();
		
		qnaAnswerVo.setQnaSequence(qnaSequence);
		qnaAnswerVo.setContent(answerContent);
		qnaService.answer(qnaAnswerVo);
	}
}

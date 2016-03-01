package org.redborn.csatlatte.controller.data.question;

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

/**
 * 문의답변입니다.
 */
@Controller
@RequestMapping("/data/question/answer")
public class Answer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	
	/**
	 * 문의답변 추가입니다.
	 * 
	 * @param model
	 * @param qnaSequence 문의번호입니다.
	 * @param answerContent 답변내용입니다.
	 */
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

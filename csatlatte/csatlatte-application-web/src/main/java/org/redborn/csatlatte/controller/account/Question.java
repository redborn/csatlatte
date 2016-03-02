package org.redborn.csatlatte.controller.account;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.QnaVo;
import org.redborn.csatlatte.service.QnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 사용자 문의내역입니다.
 */
@Controller
@RequestMapping("/{id}/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 문의사항의 제목 목록을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("Controller account question GET");
		model.addAttribute("questionList", qnaService.listForStudent(httpSessionValue.getStudentSequence()));
		return TilesName.PROFILE_QUESTION_LIST;
	}

	/**
	 * 문의 상세 내용, 첨부한 파일을 조회하는 페이지입니다.
	 */
	@RequestMapping(value="{qnaSequence}",method=RequestMethod.GET)
	public String detail(Model model, @PathVariable int qnaSequence) {
		logger.info("Controller account question DETAIL.");
		String result = TilesName.ERROR_404;
		QnaVo qnaVo = qnaService.detail(qnaSequence);
		if (qnaVo != null) {
			if (qnaVo.getStudentSequence() == httpSessionValue.getStudentSequence() && qnaVo.getUseYn().equals("Y")) {
				model.addAttribute("files", qnaService.fileList(qnaSequence));
				model.addAttribute("detail", qnaVo);
				result = TilesName.PROFILE_QUESTION_DETAIL;
			}
		}
		return result;
	}
	
	/**
	 * 문의를 삭제하는 기능입니다.
	 */
	@RequestMapping(value="{qnaSequence}",method=RequestMethod.DELETE)
	public String delete(Model model, @PathVariable int qnaSequence) {
		logger.info("profile question delete");
		String result = TilesName.ERROR_404;
		if (qnaService.delete(qnaSequence)) {
			model.addAttribute("questionList", qnaService.listForStudent(httpSessionValue.getStudentSequence()));
			result = TilesName.PROFILE_QUESTION_LIST;
		}
		return result;
	}
}
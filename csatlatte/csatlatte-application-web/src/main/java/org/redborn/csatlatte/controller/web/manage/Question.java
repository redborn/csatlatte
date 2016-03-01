package org.redborn.csatlatte.controller.web.manage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.redborn.csatlatte.commons.pagination.BootstrapPaginationWriter;
import org.redborn.csatlatte.commons.pagination.Pagination;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.QnaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 문의관리입니다.
 */
@Controller
@RequestMapping("/manage/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	
	/**
	 * 문의 목록입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model, HttpServletRequest request, @RequestParam(value="search",required=false,defaultValue="") String search, @RequestParam(value="pageNumber",required=false,defaultValue="1") int pageNumber,
			@RequestParam(value="countQnaAnswer",required=false,defaultValue="2") String countQnaAnswerString) {
		logger.info("manage question view");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("search", search);
		params.put("countQnaAnswer", countQnaAnswerString);
		
		int countQnaAnswer = Integer.parseInt(countQnaAnswerString);
		
		Pagination pagination = new Pagination(pageNumber, qnaService.amountQuestion(search, countQnaAnswer));
		
		model.addAttribute("paginationWriter", new BootstrapPaginationWriter(pagination, new StringBuilder(request.getContextPath()).append("/manage/question").toString(), params, "pageNumber"));
		model.addAttribute("list", qnaService.listForManage(search, pagination.getBeginRow() - 1, countQnaAnswer));
		return TilesName.MANAGE_QUESTION;
	}
}

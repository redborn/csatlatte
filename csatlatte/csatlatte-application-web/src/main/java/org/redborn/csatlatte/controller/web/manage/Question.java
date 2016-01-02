package org.redborn.csatlatte.controller.web.manage;

import java.util.HashMap;
import java.util.Map;

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
 * 문의를 조회하고 답변을 작성할 수 있는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/manage/question")
public class Question {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QnaService qnaService;
	/**
	 * 문의목록을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model, @RequestParam(value="search",required=false,defaultValue="") String search, @RequestParam(value="pageNumber",required=false,defaultValue="1") int pageNumber,
			@RequestParam(value="useYn",required=false,defaultValue="") String useYn) {
		logger.info("manage question view");
		
		int beginPageNumber = (pageNumber * 10) - 10;
		Map<String, String> params = new HashMap<String, String>();
		params.put("search", search);
		params.put("useYn", useYn);
		
		Pagination pagination = new Pagination(pageNumber, qnaService.amountQuestion());
		
		model.addAttribute("paginationWriter", new BootstrapPaginationWriter(pagination, "http://localhost:8080/csatlatte-application-web/manage/question", params, "pageNumber"));
		model.addAttribute("list", qnaService.listForManage(search, beginPageNumber, useYn));
		return TilesName.MANAGE_QUESTION;
	}
}

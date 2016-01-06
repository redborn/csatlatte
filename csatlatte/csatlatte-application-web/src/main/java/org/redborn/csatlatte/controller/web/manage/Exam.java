package org.redborn.csatlatte.controller.web.manage;

import java.util.HashMap;
import java.util.Map;

import org.redborn.csatlatte.commons.pagination.BootstrapPaginationWriter;
import org.redborn.csatlatte.commons.pagination.Pagination;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 새 모의고사를 작성하거나 기존 모의고사의 정보를 수정하는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/manage/exam")
public class Exam {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	
	/**
	 * 모의고사 목록을 조회하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model, @RequestParam(value="search",required=false,defaultValue="") String search, @RequestParam(value="pageNumber",required=false,defaultValue="1") int pageNumber) {
		logger.info("manage exam view");
		
		int beginPageNumber = (pageNumber * 10) - 10;
		Map<String, String> params = new HashMap<String, String>();
		params.put("search", search);
		
		Pagination pagination = new Pagination(pageNumber, examService.amountExam(search));
		
		model.addAttribute("paginationWriter", new BootstrapPaginationWriter(pagination, "http://localhost:8080/csatlatte-application-web/manage/exam", params, "pageNumber"));
		model.addAttribute("list", examService.listForManage(beginPageNumber, search));
		return TilesName.MANAGE_EXAM;
	}
}

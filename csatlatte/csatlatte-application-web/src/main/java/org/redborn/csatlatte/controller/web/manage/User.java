package org.redborn.csatlatte.controller.web.manage;

import org.redborn.csatlatte.commons.pagination.BootstrapPaginationWriter;
import org.redborn.csatlatte.commons.pagination.Pagination;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 사용자 정보를 조회하고 관리자 권한, 계정에 대한 차단 등을 설정하는 controller 입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/manage/user")
public class User {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;

	/**
	 * 사용자 정보를 관리하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model, @RequestParam(value="search",required=false,defaultValue="") String search, @RequestParam(value="pageNumber",required=false,defaultValue="1") int pageNumber) {
		logger.info("manage user view");
		
		int beginPageNumber;
		beginPageNumber = (pageNumber * 10) - 10;
		
		Pagination pagination = new Pagination(pageNumber, studentService.amountStudent());
		
		model.addAttribute("paginationWriter", new BootstrapPaginationWriter(pagination, "http://localhost:8080/csatlatte-application-web/manage/user", "pageNumber"));
		model.addAttribute("userList", studentService.userList(search, beginPageNumber));
		
		return TilesName.MANAGE_USER;
	}
}

package org.redborn.csatlatte.controller.web.manage;

import java.util.List;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.StudentVo;
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
	public String get(Model model, @RequestParam(value="search",required=false,defaultValue="") String search, @RequestParam(value="pageNumber",required=false,defaultValue="0") int pageNumber,
			@RequestParam(value="beginPageNumber",required=false,defaultValue="1") int beginPageNumber) {
		logger.info("manage user view");
		
		int amountStudent = studentService.amountStudent();
		int endPageNumber;
		int maxPageNumber = amountStudent / 10;
		
		if (amountStudent % 10 != 0) {
			maxPageNumber++;
		}
		
		int selectedPageNumber = beginPageNumber;
		beginPageNumber = (beginPageNumber - 1) / 10 * 10 + 1;
		endPageNumber = beginPageNumber + 9;
		
		if (endPageNumber > maxPageNumber) {
			endPageNumber = maxPageNumber;
		}
		
		if (pageNumber < 0) {
			pageNumber = 0;
		}
		
		if (beginPageNumber <= 0) {
			beginPageNumber = 1;
		}
		
		if (beginPageNumber > maxPageNumber) {
			beginPageNumber = maxPageNumber;
		}

		model.addAttribute("selectedPageNumber", selectedPageNumber);
		model.addAttribute("beginPageNumber", beginPageNumber);
		model.addAttribute("endPageNumber", endPageNumber);
		model.addAttribute("maxPageNumber", maxPageNumber);
		model.addAttribute("userList", studentService.userList(search, pageNumber));
		return TilesName.MANAGE_USER;
	}
}

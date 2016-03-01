package org.redborn.csatlatte.controller.account.data;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 내가 작성한 커뮤니티 글에 대한 data controller 영역입니다.
 */
@Controller
@RequestMapping("/{id}/data/community")
public class Community {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 내가 작성한 커뮤니티 글 목록을 조회하는 method 입니다.
	 * @param model
	 * @param start 페이지에 나타낼 첫번째 호출 커뮤니티의 글 번호입니다.
	 * @param end 페이지에 나타낼 마지막 호출 커뮤니티의 글 번호입니다.
	 * @param limit 페이지에 나타낼 커뮤니티 글의 갯수입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void detail(Model model, @RequestParam(value="start",required=false,defaultValue="-1") int start, @RequestParam(value="end",required=false,defaultValue="-1") int end, @RequestParam(value="limit",required=false,defaultValue="10") int limit) {
		logger.info(new StringBuilder("data community list... studentSequence is ").append(httpSessionValue.getStudentSequence()).toString());
		model.addAttribute("list", communityService.list(CommunityService.COMMUNITY, start, end, limit, httpSessionValue.getStudentSequence(), httpSessionValue.getStudentSequence()));
	}

}
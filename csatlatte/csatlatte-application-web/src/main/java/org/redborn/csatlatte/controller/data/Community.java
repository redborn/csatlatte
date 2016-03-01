package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.commons.servlet.http.HttpServletRequestValue;
import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.domain.CommunityVo;
import org.redborn.csatlatte.service.CommunityService;
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
 * 커뮤니티 data controller 입니다.
 */
@Controller
@RequestMapping("/data/community")
public class Community {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	@Autowired
	private HttpServletRequestValue httpServletRequestValue;
	
	/**
	 * 커뮤니티 페이지에 나타낼 커뮤니티 글 목록을 조회하는 method입니다.
	 * @param model
	 * @param start 페이지에 출력할 커뮤니티 글의 시작 번호입니다.
	 * @param end 페이지에 출력할 커뮤니티 글의 마지막 번호입니다.
	 * @param limit 페이지에 출력할 글의 갯수입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="start",required=false,defaultValue="-1") int start, @RequestParam(value="end",required=false,defaultValue="-1") int end, @RequestParam(value="limit",required=false,defaultValue="10") int limit) {
		logger.info("data community list");
		model.addAttribute("list", communityService.list(CommunityService.COMMUNITY, start, end, limit, httpSessionValue.getStudentSequence()));
	}

	/**
	 * 커뮤니티 글을 등록,작성하는 method입니다.
	 * @param model
	 * @param content 커뮤니티 글의 내용입니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void post(Model model, @RequestParam(value="content",required=true) String content) {
		logger.info("data community write");
		CommunityVo communityVo = new CommunityVo();
		communityVo.setCommunityTypeSequence(CommunityService.COMMUNITY);
		communityVo.setStudentSequence(httpSessionValue.getStudentSequence());
		communityVo.setContent(content);
		model.addAttribute("result", communityService.write(communityVo, httpServletRequestValue.getUserAgent(), httpServletRequestValue.getSessionId(), httpServletRequestValue.getIp()));
	}
	
	/**
	 * 커뮤니티 글을 삭제하는 method입니다.
	 * @param model
	 * @param communitySequence 삭제할 커뮤니티 글 번호입니다.
	 */
	@RequestMapping(value="{communitySequence}",method=RequestMethod.DELETE)
	public void delete(Model model, @PathVariable int communitySequence) {
		logger.info(new StringBuilder("data community delete... community is ").append(communitySequence).toString());
		model.addAttribute("result", communityService.delete(CommunityService.COMMUNITY, communitySequence, httpSessionValue.getStudentSequence()));
	}
	
}
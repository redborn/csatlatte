package org.redborn.csatlatte.controller.data.community.comment;

import org.redborn.csatlatte.commons.servlet.http.HttpServletRequestValue;
import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
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
 * 커뮤니티 댓글 신고입니다.
 */
@Controller
@RequestMapping("/data/community/comment/report")
public class Report {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	@Autowired
	private HttpServletRequestValue httpServletRequestValue;

	/**
	 * 커뮤니티 댓글을 신고합니다.
	 * 
	 * @param model
	 * @param communitySequence 커뮤니티 일련번호
	 * @param commentSequence 댓글 일련번호
	 * @param reportTypeSequence 신고 일련번호
	 */
	@RequestMapping(value="{communitySequence}/{commentSequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="communitySequence") int communitySequence, @PathVariable(value="commentSequence") int commentSequence, @RequestParam(value="reportTypeSequence",required=true) int reportTypeSequence) {
		logger.info("Controller data community comment report POST");
		model.addAttribute("result", communityService.reportComment(httpSessionValue.getStudentSequence(), CommunityService.COMMUNITY, communitySequence, commentSequence, reportTypeSequence, httpServletRequestValue.getUserAgent(), httpServletRequestValue.getSessionId(), httpServletRequestValue.getIp()));
	}
	
}
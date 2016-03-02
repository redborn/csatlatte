package org.redborn.csatlatte.controller.data.community;

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
 * 커뮤니티 글 신고입니다.
 */
@Controller
@RequestMapping("/data/community/report")
public class Report {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	@Autowired
	private HttpServletRequestValue httpServletRequestValue;
	
	/**
	 * 커뮤니티 글 신고입니다.
	 * 
	 * @param model
	 * @param communitySequence 커뮤니티 일련번호
	 * @param reportTypeSequence 신고 일련번호
	 */
	@RequestMapping(value="{communitySequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="communitySequence") int communitySequence, @RequestParam(value="reportTypeSequence",required=true) int reportTypeSequence) {
		logger.info(new StringBuilder("Controller data community report... communitySequence is ").append(communitySequence).toString());
		model.addAttribute("result", communityService.report(httpSessionValue.getStudentSequence(), CommunityService.COMMUNITY, communitySequence, reportTypeSequence, httpServletRequestValue.getUserAgent(), httpServletRequestValue.getSessionId(), httpServletRequestValue.getIp()));
	}

}
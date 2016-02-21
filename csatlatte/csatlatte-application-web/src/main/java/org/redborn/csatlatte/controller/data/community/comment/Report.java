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

	@RequestMapping(value="{communitySequence}/{commentSequence}",method=RequestMethod.POST)
	public void post(Model model, @PathVariable(value="communitySequence") int communitySequence, @PathVariable(value="commentSequence") int commentSequence, @RequestParam(value="reportTypeSequence",required=true) int reportTypeSequence) {
		logger.info(new StringBuilder("data community comment report... communitySequence is ").append(communitySequence).append(" commentSequence is ").append(commentSequence).toString());
		model.addAttribute("result", communityService.reportComment(httpSessionValue.getStudentSequence(), CommunityService.COMMUNITY, communitySequence, commentSequence, reportTypeSequence, httpServletRequestValue.getUserAgent(), httpServletRequestValue.getSessionId(), httpServletRequestValue.getIp()));
	}
	
}
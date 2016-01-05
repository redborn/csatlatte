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

@Controller
@RequestMapping("/{id}/data/community")
public class Community {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	@RequestMapping(method=RequestMethod.GET)
	public void detail(Model model, @RequestParam(value="start",required=false,defaultValue="-1") int start, @RequestParam(value="end",required=false,defaultValue="-1") int end, @RequestParam(value="limit",required=false,defaultValue="10") int limit) {
		logger.info(new StringBuilder("data community list... studentSequence is ").append(httpSessionValue.getStudentSequence()).toString());
		model.addAttribute("list", communityService.list(CommunityService.COMMUNITY, start, end, limit, httpSessionValue.getStudentSequence(), httpSessionValue.getStudentSequence()));
	}

}
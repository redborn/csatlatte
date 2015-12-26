package org.redborn.csatlatte.controller.data;

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
 * 커뮤니티 controller 입니다.
 * 
 * @author 최순열
 *
 */
@Controller
@RequestMapping("/data/community")
public class Community {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	@RequestMapping(method=RequestMethod.GET)
	public void get(Model model, @RequestParam(value="start",required=false,defaultValue="-1") int start, @RequestParam(value="end",required=false,defaultValue="-1") int end, @RequestParam(value="limit",required=false,defaultValue="10") int limit) {
		logger.info("data community list");
		model.addAttribute("list", communityService.list(CommunityService.COMMUNITY, start, end, limit));
	}
	
	@RequestMapping(value="{studentSequence}",method=RequestMethod.GET)
	public void detail(Model model, @PathVariable int studentSequence) {
		logger.info("data community detail");
		communityService.list(CommunityService.COMMUNITY, studentSequence);
	}

	@RequestMapping(method=RequestMethod.POST)
	public void post(Model model, @RequestParam(value="content",required=true) String content) {
		logger.info("data community write");
		CommunityVo communityVo = new CommunityVo();
		communityVo.setCommunityTypeSequence(CommunityService.COMMUNITY);
		communityVo.setStudentSequence(httpSessionValue.getStudentSequence());
		communityVo.setContent(content);
		model.addAttribute("result", communityService.write(communityVo));
	}
	
}
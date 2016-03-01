package org.redborn.csatlatte.controller.data.community.stats;

import org.redborn.csatlatte.service.CommunityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 연간 커뮤니티 통계에 대한 data controller 영역입니다.
 */
@Controller
@RequestMapping("/data/community/stats/annual")
public class Annual {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	/**
	 * 특정 연도의 커뮤니티 활성도를 조회하는 method입니다.
	 * @param model
	 * @param year 조회하고자 하는 연도값입니다.
	 */
	@RequestMapping(value="{year}",method=RequestMethod.GET)
	public void get(Model model, @PathVariable(value="year") String year) {
		logger.info("data stats annualcommunity view");
		
		model.addAttribute("annualActive",communityService.annualActive(CommunityService.COMMUNITY, year));
	}
}

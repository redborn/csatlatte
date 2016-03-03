package org.redborn.csatlatte.controller.web.manage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.redborn.csatlatte.commons.pagination.BootstrapPaginationWriter;
import org.redborn.csatlatte.commons.pagination.Pagination;
import org.redborn.csatlatte.commons.tiles.TilesName;
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
 * 커뮤니티 관리입니다.
 */
@Controller
@RequestMapping("/manage/community")
public class Community {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CommunityService communityService;
	
	/**
	 * 커뮤니티 글 목록입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model, HttpServletRequest request, @RequestParam(value="communityTypeSequence",required=false,defaultValue="1") int communityTypeSequence,
			@RequestParam(value="search",required=false,defaultValue="") String search, @RequestParam(value="pageNumber",required=false,defaultValue="1") int pageNumber) {
		logger.info("Controller manage community GET.");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("search", search); 
		Pagination pagination = new Pagination(pageNumber, communityService.getCount(search));
		
		model.addAttribute("list", communityService.list(CommunityService.COMMUNITY, search, pagination.getBeginRow() - 1));
		model.addAttribute("paginationWriter", new BootstrapPaginationWriter(pagination, new StringBuilder(request.getContextPath()).append("/manage/community").toString(), params, "pageNumber"));
		return TilesName.MANAGE_COMMUNITY;
	}
}

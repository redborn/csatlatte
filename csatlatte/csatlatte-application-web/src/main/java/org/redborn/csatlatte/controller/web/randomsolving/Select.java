package org.redborn.csatlatte.controller.web.randomsolving;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/randomsolving/select")
public class Select {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("Controller randomsolving select GET.");
		return TilesName.RANDOMSOLVING_SELECT;
	}
	

}

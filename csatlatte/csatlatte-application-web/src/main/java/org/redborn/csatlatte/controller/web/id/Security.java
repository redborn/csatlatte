package org.redborn.csatlatte.controller.web.id;

import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 아이디 찾기 보안확인입니다.
 */
@Controller
@RequestMapping("/id/security")
public class Security {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 아이디 찾기에 보안확인 인증을 처리합니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(Model model, @RequestParam(value="nickname",required=true) String nickname,
			@RequestParam(value="securityAnswer",required=true) String securityAnswer) {
		logger.info("find id security");
		
		String findId = studentService.findId(nickname, securityAnswer);

		String result = TilesName.ID_SECURITY_FAIL;
		if (findId != null) {
			StringBuilder id = new StringBuilder();
			String resultFindId = findId.substring(0, 4);
			id.append(resultFindId);
			int findIdLength = findId.length() - 4;
			
			for (int index = 0; index < findIdLength; index++) {
				id.append("*");
			}
			
			model.addAttribute("id", id.toString());
			result = TilesName.ID_SECURITY_SUCCESS;
		}
		
		return result;
	}
	
}

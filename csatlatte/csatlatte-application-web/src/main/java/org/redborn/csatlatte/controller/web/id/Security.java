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
 * 아이디 찾기를 진행 중 사용자 본인임을 확인하는 controller 입니다.
 */
@Controller
@RequestMapping("/id/security")
public class Security {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 아이디 찾기에 필요한 보안확인 인증을 처리합니다.
	 * 
	 * 입력한 답변이 찾으려는 아이디의 보안답변과 일치하는 경우 아이디 찾기 완료 페이지(TilesName.ID_SECURITY_SUCCESS)로 이동합니다.
	 * 
	 * 입력한 답변이 해당 아이디의 보안답변과 일치하지 않는 경우 아이디 찾기 보안확인 실패 페이지(TilesName.ID_SECURITY_FAIL)를 출력합니다.
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

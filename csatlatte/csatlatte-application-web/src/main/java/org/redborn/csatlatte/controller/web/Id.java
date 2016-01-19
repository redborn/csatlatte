package org.redborn.csatlatte.controller.web;

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
 * 분실한 아이디를 찾는 controller입니다.
 * 
 * @author 최순현
 */
@Controller
@RequestMapping("/id")
public class Id {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	/**
	 * 찾으려는 아이디의 닉네임을 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get() {
		logger.info("find id view");
		return TilesName.ID_WRITE;
	}

	/**
	 * 입력한 닉네임이 DB상에 존재여부를 판단하는 영역입니다.
	 * 
	 * 입력한 닉네임이 존재하는 경우 아이디 찾기 보안확인 페이지(TilesName.ID_SECURITY_WRITE)로 이동합니다.
	 * 
	 * 입력한 닉네임이 존재하지 않는 경우 아이디 찾기 실패 페이지(TilesName.ID_FAIL)를 출력합니다. 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(Model model, @RequestParam(value="nickname",required=true) String nickname) {
		logger.info("find id nickname");
		
		boolean success = studentService.overlapCheckNickname(nickname);
		
		String result = TilesName.ID_FAIL;
		if (success) {
			int studentSequence = studentService.nicknameStudentSequence(nickname);
			logger.info("번호 : " + studentSequence);
			model.addAttribute("securityQuestion", studentService.securityQuestion(studentSequence));
			logger.info("질문 : " + studentService.securityQuestion(studentSequence));
			result = TilesName.ID_SECURITY_WRITE;
		}
		
		return result;
	}
}

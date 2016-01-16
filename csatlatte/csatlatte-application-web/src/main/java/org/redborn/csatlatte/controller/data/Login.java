package org.redborn.csatlatte.controller.data;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/data/login")
public class Login {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 사용자 등록에 필요한 정보를 입력하는 페이지입니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void get(@RequestParam(value="id",required=true) String id, @RequestParam(value="password",required=true) String password, Model model) {
		StringBuilder loggerStr = new StringBuilder("login ");
		StudentVo studentVo = studentService.information(id, password);
		boolean result = false;
		if (studentVo != null) {
			httpSessionValue.setUser(id, studentVo.getStudentSequence(), studentVo.getNickname(), studentVo.getRuleSequence(), studentVo.getCsatSequence());
			result = true;
			loggerStr.append("success.");
		} else {
			loggerStr.append("fail.");
		}
		loggerStr.append(" ID is ").append(id);
		logger.info(loggerStr.toString());
		model.addAttribute("result", result);
	}
	
}
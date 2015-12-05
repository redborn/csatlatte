package org.redborn.csatlatte.controller.web;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
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
	public String get(@RequestParam(value="id",required=true) String id, @RequestParam(value="password",required=true) String password) {
		StringBuilder loggerStr = new StringBuilder("login ");
		StudentVo studentVo = studentService.information(id, password);
		if (studentVo != null) {
			httpSessionValue.setUser(studentVo.getStudentSequence(), studentVo.getNickname(), HttpSessionValue.STUDENT);
			loggerStr.append("success.");
		} else {
			loggerStr.append("fail.");
		}
		loggerStr.append(" ID is ").append(id);
		logger.info(loggerStr.toString());
		return "redirect:/main";
	}

}

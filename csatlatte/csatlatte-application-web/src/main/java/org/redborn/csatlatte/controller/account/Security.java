package org.redborn.csatlatte.controller.account;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 사용자 보안질문을 변경합니다.
 */
@Controller
@RequestMapping("/{id}/security")
public class Security {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpSessionValue httpSessionValue;

	/**
	 * 보안변경 처리 영역입니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="securityQuestionSequence",required=true) int securityQuestionSequence,
			@RequestParam(value="answer",required=true) String answer) {
		logger.info("myinfo security modify");
		String result = TilesName.PROFILE_SECURITY_FAIL;
		StudentSecurityQuestionVo studentSecurityQuestionVo = new StudentSecurityQuestionVo();
		studentSecurityQuestionVo.setStudentSequence(httpSessionValue.getStudentSequence());
		studentSecurityQuestionVo.setSecurityQuestionSequence(securityQuestionSequence);
		studentSecurityQuestionVo.setContent(answer);
		if (studentService.changeSecurity(studentSecurityQuestionVo)) {
			result = TilesName.PROFILE_SECURITY_SUCCESS;
		}
		return result;
	}
}
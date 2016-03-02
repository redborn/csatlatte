package org.redborn.csatlatte.controller.web;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.redborn.csatlatte.commons.io.FileDirectory;
import org.redborn.csatlatte.commons.tiles.TilesName;
import org.redborn.csatlatte.domain.CsatVo;
import org.redborn.csatlatte.domain.StudentSecurityQuestionVo;
import org.redborn.csatlatte.domain.StudentVo;
import org.redborn.csatlatte.service.ExamService;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 회원가입입니다.
 */
@Controller
@RequestMapping("/join")
public class Join {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	@Autowired
	private ExamService examService;

	/**
	 * 회원가입입니다.
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("Controller join GET.");
		
		List<CsatVo> csatList = examService.csatList();
		int presentCsatSequence = 0;
		
		Calendar calendar = Calendar.getInstance();
		int presentYear = calendar.get(Calendar.YEAR); 
		
		if (csatList != null) {
			int csatListSize = csatList.size();
			for (int index = 0; index < csatListSize; index++) {
				CsatVo csatVo = csatList.get(index);
				String examYmd = csatVo.getExamYmd();
				if (examYmd != null && examYmd.length() >= 4) {
					if (Integer.parseInt(examYmd.substring(0, 4)) == presentYear) {
						presentCsatSequence = csatVo.getCsatSequence();
						break;
					}
				}
			}
		}
		
		model.addAttribute("presentCsatSequence", presentCsatSequence);
		model.addAttribute("securityQuestionList", studentService.securityQuestionList());
		model.addAttribute("csatList", examService.csatList());
		
		return TilesName.JOIN_WRITE;
	}
	
	/**
	 * 회원가입 처리입니다.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="studentId",required=true) String studentId, @RequestParam(value="password",required=true) String password,
			@RequestParam(value="securityQuestion",required=true) int securityQuestion, @RequestParam(value="answer",required=true) String answer, 
			@RequestParam(value="nickname",required=true) String nickname, @RequestParam(value="csat",required=true) int csat, @RequestParam(value="photo",required=false) MultipartFile photo) {
		logger.info("Controller join POST.");
		String result = TilesName.JOIN_FAIL;
		if (!studentService.isId(studentId) && !studentService.isNickname(nickname)) {
			StudentVo studentVo = new StudentVo();
			StudentSecurityQuestionVo studentSecurityQuestionVo = new StudentSecurityQuestionVo();
			
			studentVo.setStudentId(studentId);
			studentVo.setStudentPassword(password);
			studentVo.setNickname(nickname);
			studentVo.setCsatSequence(csat);
			studentSecurityQuestionVo.setSecurityQuestionSequence(securityQuestion);
			studentSecurityQuestionVo.setContent(answer);
			File file = null; 
			boolean fileError = false;
			if (!photo.isEmpty()) {
				String originalFileName = photo.getOriginalFilename();
				String originalFileNameLowerCase = originalFileName.toLowerCase();
				file = new File(new StringBuilder(FileDirectory.TEMP).append("/").append(originalFileName).toString());
				if (originalFileNameLowerCase.endsWith(".jpg") || originalFileNameLowerCase.endsWith(".gif") || originalFileNameLowerCase.endsWith(".png") || originalFileNameLowerCase.endsWith(".jpeg")) {
					try {
						photo.transferTo(file);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					fileError = true;
				}
			}
			
			if (!fileError) {
				if (studentService.join(studentVo, studentSecurityQuestionVo, file)) {
					result = TilesName.JOIN_SUCCESS;
				}
			}
		}
		
		return result;
	}
}
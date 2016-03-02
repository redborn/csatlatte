package org.redborn.csatlatte.controller.account;

import java.io.File;
import java.io.IOException;

import org.redborn.csatlatte.commons.io.FileDirectory;
import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.tiles.TilesName;
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
 * 사용자 정보 수정입니다.
 */
@Controller
@RequestMapping("/{id}/modify")
public class Modify {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExamService examService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	@Autowired
	private StudentService studentService;

	/**
	 * 닉네임 입력, 프로필 사진 등록, 수능을 선택하는 페이지입니다.
	 * 
	 * @param model
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String get(Model model) {
		logger.info("Controller account modify GET.");
		model.addAttribute("csatList", examService.csatList());
		return TilesName.PROFILE_MODIFY_WRITE;
	}

	/**
	 * 내 정보 변경 처리 영역입니다. 
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String post(@RequestParam(value="csatSequence",required=true) int csatSequence,
			@RequestParam(value="nickname",required=true) String nickname, @RequestParam(value="photo",required=false) MultipartFile photo, 
			@RequestParam(value="photoDelete",required=false,defaultValue="false") boolean photoDelete) {
		logger.info("Controller account modify POST.");
		String result = TilesName.PROFILE_MODIFY_FAIL;
		boolean fileError = false;
		StudentVo studentVo = new StudentVo();
		studentVo.setStudentSequence(httpSessionValue.getStudentSequence());
		studentVo.setCsatSequence(csatSequence);
		studentVo.setNickname(nickname);
		File file = null;
		if (!photo.isEmpty()) {
			String originalFileName = photo.getOriginalFilename();
			String originalFileNameLowerCase = originalFileName.toLowerCase();
			if (originalFileNameLowerCase.endsWith(".jpg") || originalFileNameLowerCase.endsWith(".png") || originalFileNameLowerCase.endsWith(".gif") || originalFileNameLowerCase.endsWith(".jpeg")) {
				file = new File(new StringBuilder(FileDirectory.TEMP).append("/").append(originalFileName).toString());
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
			if (studentService.changeInformation(studentVo, file, photoDelete)) {
				httpSessionValue.setUser(httpSessionValue.getId(), httpSessionValue.getStudentSequence(), nickname, httpSessionValue.getRuleSequence(), csatSequence);
				result = TilesName.PROFILE_MODIFY_SUCCESS;
			}
		}
		return result;
	}

}
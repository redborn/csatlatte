package org.redborn.csatlatte.controller.file;

import org.redborn.csatlatte.commons.servlet.http.HttpSessionValue;
import org.redborn.csatlatte.commons.spring.web.servlet.view.FileOutputStreamView;
import org.redborn.csatlatte.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

/**
 * 사용자 프로필 사진입니다.
 */
@Controller
@RequestMapping("/file/student")
public class Student {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private HttpSessionValue httpSessionValue;
	
	/**
	 * 사용자 프로필 사진입니다.
	 * 
	 * @param studentSequence 학생 일련번호
	 */
	@RequestMapping(value="{studentSequence}",method=RequestMethod.GET)
	public View get(@PathVariable(value="studentSequence") int studentSequence) {
		logger.info(new StringBuilder("Controller file student. studentSequence is ").append(studentSequence).append(".").toString());
		View view = null;
		String photoName = studentService.getPhotoName(studentSequence);
		if (photoName != null) {
			int beginIndex = photoName.lastIndexOf('.');
			String extension = null;
			if (beginIndex >= 0) {
				extension = photoName.substring(beginIndex);
			}
			view = new FileOutputStreamView(studentService.getInputStream(studentSequence), extension, photoName);
		} else {
			view = new FileOutputStreamView(this.getClass().getResourceAsStream("/org/redborn/csatlatte/commons/spring/web/servlet/view/img_profile.png"), FileOutputStreamView.PNG, "img_profile.png");
		}
		return view;
	}
	
}

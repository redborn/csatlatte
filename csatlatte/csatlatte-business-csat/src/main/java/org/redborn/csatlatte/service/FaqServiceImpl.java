package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.FaqVo;
import org.redborn.csatlatte.persistence.FaqDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqServiceImpl implements FaqService {
	
	@Autowired
	private FaqDao faqDao;
	
	public List<FaqVo> list(int faqTypeSequence) {
		return faqDao.selectList(faqTypeSequence);
	}

}
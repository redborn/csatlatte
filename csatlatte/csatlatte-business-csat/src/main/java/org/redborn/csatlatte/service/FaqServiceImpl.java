package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.FaqVo;
import org.redborn.csatlatte.persistence.FaqDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqServiceImpl implements FaqService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FaqDao faqDao;
	
	public List<FaqVo> list(int faqTypeSequence) {
		logger.info("Business layer faq list.");
		return faqDao.selectList(faqTypeSequence);
	}

}
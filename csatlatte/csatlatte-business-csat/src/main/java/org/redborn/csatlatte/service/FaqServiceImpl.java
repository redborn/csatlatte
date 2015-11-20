package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.TypeVo;
import org.redborn.csatlatte.domain.FaqVo;
import org.redborn.csatlatte.persistence.FaqDao;
import org.redborn.csatlatte.persistence.faq.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private TypeDao typeDao;
	@Autowired
	private FaqDao faqDao;
	
	public List<FaqVo> list(int faqTypeSequence) {
		return faqDao.selectList(faqTypeSequence);
	}
	
	public List<TypeVo> typeList() {
		return typeDao.selectList();
	}

}
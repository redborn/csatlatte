package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.FaqTypeVo;
import org.redborn.csatlatte.persistence.faq.TypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private TypeDao typeDao;
	
	public List<FaqTypeVo> typeList() {
		return typeDao.selectList();
	}

}
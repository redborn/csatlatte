package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.TypeVo;
import org.redborn.csatlatte.domain.FaqVo;

public interface FaqService {
	
	public List<FaqVo> list(int faqTypeSequence);
	public List<TypeVo> typeList();

}
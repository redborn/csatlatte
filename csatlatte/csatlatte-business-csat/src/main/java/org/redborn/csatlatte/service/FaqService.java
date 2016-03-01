package org.redborn.csatlatte.service;

import java.util.List;

import org.redborn.csatlatte.domain.FaqVo;

/**
 * FAQ 서비스입니다.
 */
public interface FaqService {
	
	/**
	 * FAQ 목록입니다.
	 * @param faqTypeSequence FAQ 카테고리입니다.
	 * @return
	 */
	public List<FaqVo> list(int faqTypeSequence);

}
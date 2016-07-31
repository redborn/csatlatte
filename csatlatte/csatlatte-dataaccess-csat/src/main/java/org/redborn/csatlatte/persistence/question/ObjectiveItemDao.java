package org.redborn.csatlatte.persistence.question;

import java.util.List;

import org.redborn.csatlatte.domain.ObjectiveItemVo;
import org.redborn.csatlatte.domain.QuestionVo;

public interface ObjectiveItemDao {
	
	public List<ObjectiveItemVo> selectList(QuestionVo questionVo);

}

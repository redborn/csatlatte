package org.redborn.csatlatte.persistence.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.redborn.csatlatte.domain.FileVo;
import org.springframework.stereotype.Repository;

@Repository
public class FileDaoMapper extends SqlSessionDaoSupport implements FileDao {

	public List<FileVo> selectList(int qnaSequence) {
		return getSqlSession().selectList("qna.file.selectList", qnaSequence);
	}

	public int insert(int qnaSequence, FileVo fileVo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("qnaSequence", qnaSequence);
		params.put("fileName", fileVo.getFileName());
		params.put("fileCode", fileVo.getFileCode());
		
		return getSqlSession().insert("qna.file.insert", params);
	}

}

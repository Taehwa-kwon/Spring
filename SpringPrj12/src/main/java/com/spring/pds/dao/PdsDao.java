package com.spring.pds.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

public interface PdsDao {

	List<PdsVo> getList(HashMap<String, Object> map);

	void setWrite(HashMap<String, Object> map);

	PdsVo getContent(HashMap<String, Object> map);

	List<FilesVo> getFileList(HashMap<String, Object> map);

	void setUpdate(HashMap<String, Object> map);

	void setDelete(HashMap<String, Object> map);


}

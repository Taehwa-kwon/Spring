package com.spring.pds.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.pds.vo.PdsVo;

public interface PdsDao {

	List<PdsVo> getPdsList(HashMap<String, Object> map);

}

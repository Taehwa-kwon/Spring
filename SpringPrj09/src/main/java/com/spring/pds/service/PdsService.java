package com.spring.pds.service;

import java.util.HashMap;
import java.util.List;

import com.spring.pds.vo.PdsVo;

public interface PdsService {

	List<PdsVo> getPdsList(HashMap<String, Object> map);

}

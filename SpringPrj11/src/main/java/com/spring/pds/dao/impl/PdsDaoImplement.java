package com.spring.pds.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.vo.PdsVo;



@Repository("pdsDao")
public class PdsDaoImplement implements PdsDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		sqlSession.selectList("PDS.PdsList",map);//map은 인자로 주기도 하고 결과값을 받아오기도 한다.
		List<PdsVo> pdsList = (List<PdsVo>) map.get("result");
		return pdsList;
	}

	@Override
	public void setWrite(HashMap<String, Object> map) {
		sqlSession.insert("PDS.PdsInsert",map);
	}

	@Override
	public List<PdsVo> getView(HashMap<String, Object> map) {
		sqlSession.selectList("PDS.PdsView", map);
		List<PdsVo> pdsList = (List<PdsVo>) map.get("result");
		return pdsList;
	}
	
	
}

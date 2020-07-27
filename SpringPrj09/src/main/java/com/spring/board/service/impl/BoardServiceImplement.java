package com.spring.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.BoardDao;
import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVo;

@Service("boardService")
public class BoardServiceImplement implements BoardService {
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<BoardVo> getList() {
		List<BoardVo> getList = boardDao.getList(); 
		return getList;
	}

	@Override
	public void addBoard(HashMap<String, Object> map) {
		boardDao.addBoard(map);
		
	}

	@Override
	public void Delete(HashMap<String, Object> map) {
		boardDao.Delete(map);
		
	}

	@Override
	public List<BoardVo> Update(HashMap<String, Object> map) {
		List<BoardVo> getView2 = boardDao.getView(map);
		return getView2;
	}

	
	

	

}

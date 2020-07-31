package com.spring.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.board.vo.BoardVo;

public interface BoardService {

	List<BoardVo> getList();

	void addBoard(HashMap<String, Object> map);

	void Delete(HashMap<String, Object> map);

	List<BoardVo> Update(HashMap<String, Object> map);



}

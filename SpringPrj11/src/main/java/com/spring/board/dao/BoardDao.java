package com.spring.board.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.board.vo.BoardVo;

public interface BoardDao {

	List<BoardVo> getList();

	void addBoard(HashMap<String, Object> map);

	void Delete(HashMap<String, Object> map);

	List<BoardVo> getView(HashMap<String, Object> map);

}

package com.pknu.board.dao;

import java.util.List;

import com.pknu.board.vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> getBoardList();
}

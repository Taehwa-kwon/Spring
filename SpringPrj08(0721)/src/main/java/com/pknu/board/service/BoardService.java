package com.pknu.board.service;

import java.util.List;

import com.pknu.board.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getBoardList();

	public BoardVo getContent(int idx);//2.구현 //10.

	public void getDelete(int idx);

	public void getUpdate(BoardVo vo);

	public void addBoard(BoardVo vo);

	//public void getContent_count(int idx);

	

}

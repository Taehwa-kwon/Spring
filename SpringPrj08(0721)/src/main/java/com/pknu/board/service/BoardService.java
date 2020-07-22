package com.pknu.board.service;

import java.util.List;

import com.pknu.board.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getBoardList();

	public BoardVo getContent(int idx);//2.구현 //10.

	public BoardVo getDelete(int idx);

	public void getUpdate(BoardVo vo);

	public void addBoard(BoardVo vo);



}

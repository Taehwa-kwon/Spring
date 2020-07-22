package com.pknu.board.dao;

import java.util.List;

import com.pknu.board.vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> getBoardList();

	public BoardVo getContent(int idx);//4.구현 //8.

	public BoardVo getDelete(int idx);

	public void getUpdate(BoardVo vo);

	public void addBoard(BoardVo vo);

	public void getContent_count(int idx);

	public void setIdx(int idx);


}

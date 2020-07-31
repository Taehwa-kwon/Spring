package com.spring.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardVo;

@Repository("boardDao")
public class BoardDaoImplement implements BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVo> getList() {
		HashMap<String,Object> map = new HashMap<String,Object>();//이렇게 해도되고 아니면 출발에서 HashMap으로 시작해서 넘어와도 되고
		sqlSession.selectList("Board.BoardList",map);
		
		List<BoardVo> BoardList = (List<BoardVo>) map.get("result"); 
		return BoardList;
	}

	@Override
	public void addBoard(HashMap<String, Object> map) {
		sqlSession.insert("Board.BoardInsert", map);
		
	}

	@Override
	public void Delete(HashMap<String, Object> map) {
		sqlSession.delete("Board.BoardDelete",map);
		
	}

	@Override
	public List<BoardVo> getView(HashMap<String, Object> map) {
		sqlSession.selectList("Board.BoardView", map);
		
		List<BoardVo>boardList = (List<BoardVo>) map.get("result");
		boardList.get(0);
		System.out.println("==================");
		System.out.println(boardList);
		
		return boardList;
	}

	

	
}

package com.pknu.board.dao.implement;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pknu.board.dao.BoardDao;
import com.pknu.board.vo.BoardVo;

@Repository("boardDao")
public class BoardDaoImplement implements BoardDao {
	
	//SQL SessionFactory  사용하여  DB 연결
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List<BoardVo> getBoardList() {
		List<BoardVo> list = sqlSession.selectList("Board.BoardList"); //이건 boardMapper.xml에서 namespace와 id를 가져온다.
		return list;
	}


	@Override
	public BoardVo getContent(int idx) {
		BoardVo Vo = sqlSession.selectOne("Board.BoardSelect",idx);//5.where문안에서 idx가 있어서 조회가 가능하니깐 idx를 담아서 전달한다. //7
		return Vo;
	}


	@Override
	public BoardVo getDelete(int idx) {
		
		return sqlSession.selectOne("Board.BoardDelete", idx);
	}


	@Override
	public void getUpdate(BoardVo vo) {
		System.out.println(vo);
		 sqlSession.update("Board.BoardUpdate",vo);
	}


	@Override
	public void addBoard(BoardVo vo) {
		sqlSession.insert("Board.BoardWrite",vo);
		
	}


	@Override
	public void getContent_count(int idx) {
		sqlSession.update("Board.BoardUpdateCount",idx);
		
	}


	@Override
	public void setIdx(int idx) {
		sqlSession.update("Board.BoardIdxSer",idx);
		
	}





}

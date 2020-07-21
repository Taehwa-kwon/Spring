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

}

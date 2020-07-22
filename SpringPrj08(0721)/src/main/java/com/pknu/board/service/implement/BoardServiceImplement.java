package com.pknu.board.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.board.dao.BoardDao;
import com.pknu.board.service.BoardService;
import com.pknu.board.vo.BoardVo;

@Service("boardService")
//Q.여기 borderService이름의 사용처는 어디여
public class BoardServiceImplement implements BoardService {
	@Autowired
	private BoardDao boardDao; 
	
	@Override
	public List<BoardVo> getBoardList() {
		//DB 와 직간접 관련없는 코딩을 기재한다.DB를 읽기전후에 사용할 애들이 있기때문에 DB연결 전에 행할 업무
		return boardDao.getBoardList();
		//
	}

	@Override
	public BoardVo getContent(int idx) {
		boardDao.getContent_count(idx);
		BoardVo vo = boardDao.getContent(idx);//3.Dao로 간다 //9.
		return vo; 
	}

	@Override
	public void getDelete(int idx) {
		
		boardDao.getDelete(idx);	//idx번 글 삭제
		boardDao.setIdx(idx);		// 삭제번호 채우기 
		
	}

	@Override
	public void getUpdate(BoardVo vo) {
		
		 boardDao.getUpdate(vo);
	}

	@Override
	public void addBoard(BoardVo vo) {
		boardDao.addBoard(vo);
		
	}

//	@Override
//	public void getContent_count(int idx) {
//		boardDao.getContent_count(idx);
//		
//	}



}

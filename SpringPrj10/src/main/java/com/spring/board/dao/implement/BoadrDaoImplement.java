package com.spring.board.dao.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardVo;

@Repository("boardDao")
public class BoadrDaoImplement implements BoardDao {

	@Override
	public List<BoardVo> getList() {
		//data 입력
		List<BoardVo> list = new ArrayList<BoardVo>();
		list.add(new BoardVo(1,"제목1","abc@naver.com"));
		list.add(new BoardVo(2,"제목2","abc@naver.com"));
		
		return list;
	}

}

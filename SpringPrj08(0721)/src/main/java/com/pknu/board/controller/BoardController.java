package com.pknu.board.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu.board.service.BoardService;
import com.pknu.board.vo.BoardVo;

@Controller
//전통적인 controller은 view단에 반환하기 위해서 사용한다.

public class BoardController {
	//name으로 찾는다면 Resource로 찾으면된다.. 근데 안되네 ㅅㅂ..
	//@Resource("boardService")
	@Autowired
	private BoardService boardService; 
	
	
	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/Board/List")
	public String list(Model model) {
		List<BoardVo> list = boardService.getBoardList();
		model.addAttribute("boardList",list);
		
		return "list";
	}
	
}

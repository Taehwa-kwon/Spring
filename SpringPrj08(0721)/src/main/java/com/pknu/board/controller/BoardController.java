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
	@RequestMapping("/Board/WriteForm")
	public String WriteForm() {
		
		return "write";
	}
	@RequestMapping("/Board/Write")
	public String Write(BoardVo vo) {
		boardService.addBoard(vo);
		return "redirect:/Board/List";
	}
	@RequestMapping("/Board/Content")
	public String Content(int idx,Model model) {
		System.out.println(idx);
		BoardVo vo=boardService.getContent(idx); //1.service호출 //11.
		System.out.println(vo); // BoardVo에 toString 만들어놔서 찍힐듯
		model.addAttribute("content",vo);
		
		
		return "content";
	}
	@RequestMapping("/Board/Delete")
	public String Delete(int idx,Model model) {
		BoardVo vo=boardService.getDelete(idx); 
		
		return "redirect:/Board/List";
	}
	
	@RequestMapping("/Board/UpdateForm")
	public String UpdateForm(int idx,Model model) {
		BoardVo vo= boardService.getContent(idx); 
		//아니 나는 getContent는 조회니깐 그냥 조회하고 오는줄 알았는데 
		// 조회해서 vo에 idx,title,name, regdate를 담아서 아예 가지고 와서 다시 
		//아래 model객체를 이용해서 update라는 이름으로 vo를 전달한다.
		model.addAttribute("update",vo);
		
		return "update";
	}
	
	@RequestMapping("/Board/Update")
	public String Update(BoardVo vo) {
		System.out.println("vovovo"+vo);
		boardService.getUpdate(vo); 
		
		return "redirect:/Board/List";
	}
	
}

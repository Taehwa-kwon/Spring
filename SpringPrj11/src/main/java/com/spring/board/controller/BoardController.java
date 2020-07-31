package com.spring.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.service.BoardService;
import com.spring.board.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	@RequestMapping("/Board/List")
	public ModelAndView List() {
		
		HashMap<String,Object>map = new HashMap<String,Object>();
		//List<BoardVo> boardList = boardService.getList(map);
		
		List<BoardVo> boardList = boardService.getList();		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/List"); //view 이름
		mv.addObject("boardList",boardList); //변수명,사용할 클래스
		
		return mv;
	}
	@RequestMapping("/Board/WriteForm")
	public String WriteForm() {
		
		return "board/Write";
	}
	@RequestMapping("/Board/Write")
	public String Write(BoardVo vo) {
		HashMap<String,Object>map = new HashMap<String,Object>();
		map.put("title", vo.getTitle());
		map.put("name", vo.getName());
		boardService.addBoard(map);
			
		
		return "redirect:/Board/List";
	}
	
	@RequestMapping("/Board/Delete")
	public String Delete(BoardVo vo) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("idx",vo.getIdx());
		System.out.println(map);
		boardService.Delete(map);

		return "redirect:/Board/List";
	}
	
	@RequestMapping("/Board/UpdateForm")
	public ModelAndView Update(BoardVo vo) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("idx",vo.getIdx());
		
		List<BoardVo> boardlist = boardService.Update(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/Update"); //view 이름
		mv.addObject("boardList",boardlist); //변수명,사용할 클래스
		
		return mv;
		
	}
	
	
	
}

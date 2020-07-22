package com.pknu.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pknu.board.service.BoardService;
import com.pknu.board.vo.BoardVo;

@Controller
//전통적인 controller은 view단에 반환하기 위해서 사용한다.

public class BoardController {
	
	// @Resource(name="boardService") 같은 의미다.
	@Autowired
	private BoardService boardService; 
	
//	Autowired 역할
//	private BoardService boardService;
//	public void setSqlSession(BoardService boardService) {
//		this.boardService =  boardService;
//	}
	
	/*	 ***HOME*** 	*/
	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	/*	 ***전체조회*** 	*/
	@RequestMapping("/Board/List")
	public String list(Model model) {
		List<BoardVo> list = boardService.getBoardList();
		model.addAttribute("boardList",list);
		
		return "list";
	}
	/*	 ***write*** 	*/
	@RequestMapping("/Board/WriteForm")
	public String WriteForm() {
		
		return "write";
	}
	/*	 ***write*** 	*/
	@RequestMapping("/Board/Write")
	public String Write(BoardVo vo) {
		boardService.addBoard(vo);
		return "redirect:/Board/List";
	}
	/*	 ***개인조회*** 	*/
	@RequestMapping("/Board/Content")
	public String Content(int idx,Model model) {
		
		//boardService.getContent_count(idx);//이것보다 그냥 BoardServiceImplement에서 바로 구현하는게 낫네
		
		BoardVo vo=boardService.getContent(idx); //1.service호출 //11.
		System.out.println(vo); // BoardVo에 toString 만들어놔서 찍힌다.
		model.addAttribute("content",vo);
		
		return "content";
	}
	
	/*	 ***UpdateForm*** 	*/
//	@RequestMapping("/Board/UpdateForm")
//	public String UpdateForm(int idx,Model model) {
//		BoardVo vo= boardService.getContent(idx); 
//		//아니 나는 getContent는 조회니깐 그냥 조회하고 오는줄 알았는데 
//		// 조회해서 vo에 idx,title,name, regdate를 담아서 아예 가지고 와서 다시 
//		//아래 model객체를 이용해서 update라는 이름으로 vo를 전달한다.
//		model.addAttribute("update",vo);
//		
//		return "update";
//	}
	
//	@RequestMapping("/Board/UpdateForm")
//	public ModelAndView UpdateForm(int idx) {
//		ModelAndView mv = new ModelAndView();
//		BoardVo vo= boardService.getContent(idx); 
//		mv.setViewName("update");
//		mv.addObject("update",vo);
//		
//		return mv;
//	}
	
	@RequestMapping("/Board/UpdateForm")
	public ModelAndView UpdateForm(BoardVo boardVo) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo= boardService.getContent(boardVo.getIdx()); 
		mv.setViewName("update"); //view의 이름이 되고
		mv.addObject("update",vo); //view로 보낼값 
		//ModelAndView 는 그냥 뷰의 이름과 데이터값을 바로 지정한다.
		
		return mv;
	}
	/*	 ***Update*** 	*/
	@RequestMapping("/Board/Update")
	public String Update(BoardVo vo) {
		System.out.println("vovovo"+vo);
		boardService.getUpdate(vo); 
		
		return "redirect:/Board/List";
	}
	
	/*	 ***삭제*** 	*/
	@RequestMapping("/Board/Delete")
	public ModelAndView Delete(BoardVo vo) {
		ModelAndView mv = new ModelAndView();
		
		boardService.getDelete(vo.getIdx()); 
		mv.setViewName("redirect:/Board/List");
		return mv;
	}
	
	
	
	
}

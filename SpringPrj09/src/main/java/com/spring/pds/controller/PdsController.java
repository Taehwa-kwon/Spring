package com.spring.pds.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.PdsVo;

@Controller
public class PdsController {
	
	@Autowired
	private PdsService pdsService;  
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/PDS/List")
	public ModelAndView pdsList(PdsVo vo) {
		//border+Files 조회 : menu_id 에 해당되는것을 조회한다.
		HashMap <String,Object> map = new HashMap<String,Object>();
		map.put("menu_id", vo.getMenu_id());
		List <PdsVo> pdsList = pdsService.getPdsList(map);
		
		//Menus테이블 조회
		List<MenuVo>menuList = menuService.getList(map);
		
		//List.jsp 위한 준비
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pds/list");
		mv.addObject("pdsList", pdsList);
		mv.addObject("menuList", menuList);
		
		return mv;
	}

}

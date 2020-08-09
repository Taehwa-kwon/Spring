package com.spring.menu.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;

	@RequestMapping("/Menus/List")
	public ModelAndView menuList() {
		
		//stored procedure에 값을 전달하고 돌려받기 위해서 HashMap을 사용하였다. 
		HashMap<String,Object>map = new HashMap<String, Object>(); //Map은  key값은 String value값은 Object, 키값은 중복 되면 안되고 
		//map.put("menu_id", "MENU01"); //key값, value값 인데 이게 필요하냐?? 
		
		
		List<MenuVo> menuList= menuService.getList(map);//순차적으로 데이터를 보낼떄 유리한 구조가 List
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/menuList"); //뷰의 경로
		mv.addObject("menuList",menuList); //뷰로 보낼값 (변수이름,데이터 값)
		return mv;
	}
	
	@RequestMapping("/Menus/WriteForm")
	public String writeForm() {
		return "menus/menuwrite";
	}
	
	@RequestMapping("/Menus/Write")
	public String write(MenuVo vo) {

		HashMap<String,Object>map =new HashMap<String, Object>();
		map.put("menu_name", vo.getMenu_name()); //key, value
		menuService.setWriteMenu(map); //key,value값을 그대로 전달.
				
		return "redirect:/Menus/List";
	}
	
	@RequestMapping("/Menus/Delete")
	public String Delete(MenuVo vo) {
		
		HashMap<String,Object>map =new HashMap<String, Object>();
		map.put("menu_id", vo.getMenu_id()); //key, value
		menuService.setDeleteMenu(map); //key,value값을 그대로 전달.

		//myBatis에서 프로시저를 사용하려면 대부분 map으로 받기 때문에 이렇게 넘겨줘야한다...
		// vo에 해당하는것을 map.put으로 해서 연결시켜주고 넣어주면 편함 . 
		return "redirect:/Menus/List";
	}
	
	//Delete?menu_id=menu01
	@RequestMapping("/Menus/UpdateForm")
	public ModelAndView UpdateForm(MenuVo vo) {
		
		HashMap<String,Object>map = new HashMap<String, Object>(); //Map은  key값은 String value값은 Object, 키값은 중복 되면 안되고
		map.put("menu_id", vo.getMenu_id());
		//MenuVo menuVo= menuService.getSelect(map);//순차적으로 데이터를 보낼떄 유리한 구조가 List
		List<MenuVo> menuList= menuService.getSelect2(map);//순차적으로 데이터를 보낼떄 유리한 구조가 List
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/Update"); //뷰의 경로
		mv.addObject("Update",menuList); //뷰로 보낼값 (변수이름,데이터 값)
		
		return mv;
	}
	
	@RequestMapping("/Menus/Update")
	public String Update(MenuVo vo) {

		HashMap<String,Object>map =new HashMap<String, Object>();
		map.put("menu_id", vo.getMenu_id()); //key, value
		map.put("menu_name", vo.getMenu_name()); //key, value
		map.put("menu_seq", vo.getMenu_seq()); //key, value
		menuService.setUpdateMenu(map); //key,value값을 그대로 전달.
				
		return "redirect:/Menus/List";
	}
	
	
}

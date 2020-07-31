package com.spring.pds.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.service.PdsService;

@Controller
public class PdsController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private PdsService pdsService;
	/*
	 * myBastis가 map을 쓰니깐 PdsVo vo 이렇게 해서 map.put() 이렇게 하면 너무 컬럼수가 많으면 골치아프니깐 차라리
	 * map으로 @RequestParam써서 , 넘긴다.
	 * 
	 * @RequestParam HashMap<String, Object> map 이렇게 하면 home에서 물음표 뒤에 있는게 자동으로 빈
	 * 객체안에 menu_id=MENU01 이 담긴다. 그러면 @RequestParam이 빠지면 어떻게 되는지 확인해보자
	 */
	@RequestMapping("/PDS/List")
	public ModelAndView pdsList(@RequestParam HashMap<String, Object> map) {

		List<MenuVo> menuList = menuService.getList(map);

		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuList);
		mv.addObject("menu_id", map.get("menu_id"));
		mv.setViewName("pds/list");
		return mv;
	}

	@RequestMapping("/PDS/WriteForm")
	public ModelAndView writeForm(@RequestParam HashMap<String, Object> map) {

		List<MenuVo> menuList = menuService.getList(map);
		System.out.println(menuList);

		map.put("user_id", "sky");

		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuList);
		mv.addObject("map", map); // map에는 request정보들이 모여있다. + user_id까지 추가시킴
		mv.setViewName("pds/write");
		return mv;

		/*
		 * 재밌는게 java에서는 map이 사용가능하지만 ㄱ느것을 ModelAndView를 사용해서 write로 넘겨보내준다. 그러면 서버단에
		 * java의 map이 톰캣을 통해서 map 안에 있는 정보들이 변수로 변환되어서 클라이언트단(write.jsp 혹은 view)으로 전해진다.
		 * input 안받아도 넘어가야 하는것들이 wirte.jsp에서 hidden으로 숨겨놓고 여기로 보낸다.
		 */
	}

	@RequestMapping("/PDS/Write")
	public ModelAndView write(@RequestParam HashMap<String, Object> map, HttpServletRequest request) {
		//Request요청된 정보들 map /  파일정보 받기 HttpServletRequest
		ModelAndView mv = new ModelAndView();
		List<MenuVo> menuList = menuService.getList(map);
		mv.addObject("menuList", menuList);

		mv.addObject("menu_id", map.get("menu_id"));
		
		/*페이징 관련 처리*/
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		
		
		mv.setViewName("redirect:/PDS/List");
		return mv;

	}

}

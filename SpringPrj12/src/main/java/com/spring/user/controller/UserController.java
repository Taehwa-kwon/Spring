package com.spring.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.user.user.service.UserService;
import com.spring.user.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginform() {
		return "login/loginForm";
	}
	
	//로그인 처리
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public String loginProcess(@RequestParam HashMap<String,Object> map, HttpSession session) {
		String returnURL= "";
		
		 if (session.getAttribute("login")!=null ) {
				session.removeAttribute("login");//로그인이 중복되면 안되니껭 요롷구롬 초기화 하는거징 ㅋㅋㅋ
		 }
		 
		 UserVo vo = userService.login(map);
		
		if( vo!=null ) {
			session.setAttribute("login", vo);//여기서 set을 하네  
			returnURL = "redirect:/";
		} else {
			returnURL = "redirect:/login";
		}
		return returnURL;
	}
	
	
	//로그아웃 처리 
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		session.invalidate();
		
		return "redirect:/";
		
	}

}

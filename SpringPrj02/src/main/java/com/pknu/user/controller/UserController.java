package com.pknu.user.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu.user.dao.UserDao;
import com.pknu.user.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("age",27);
		return "home";
	}
	
	@RequestMapping("/List")
	public String List(Model model) {
		List<UserVo> list = userDao.getList();
		model.addAttribute("userList",list); //list.jsp에서 userList라는 이름으로 list값을 사용 할수 있음 
		// Model 객체를 이용해서, view로 Data 전달
		return "list";
	}
	@RequestMapping("/WriteForm")
	public String WriteForm() {
		return "write";
	}
	
	@RequestMapping("/Write")
	public String write(UserVo vo, Model model) {
	//public String write(UserVo vo, Model model, HttpServletRequest request) { 이렇게 하면 String strName = request.getParameter("name(input의 name을 가져오고)"); vo.setName(strName)
		System.out.println("1"+vo);
		userDao.addUser(vo);
		//return "list";
		return "redirect:/List";
	}
	@RequestMapping("/View") //View?tel=010
	public String view(String tel,Model model) {
		System.out.println("RequestMapping view "+tel); //여기 tel에 이미 010-1111-9999가 들어온다.
		UserVo vo = userDao.getView(tel);
		model.addAttribute("user",vo);
		
		return "view";
		
	}
	@RequestMapping("/DeleteForm") //DeleteForm?tel=010
	public String del(String tel,Model model) {
		userDao.Del(tel);
		
		return "redirect:/List";
	}
	
	/*
	 * @RequestMapping("/UpdateForm") //View?tel=010 public String Update(String
	 * tel,Model model) { WriteForm();
	 * 
	 * UserVo vo = userDao.Update(tel);
	 * 
	 * return "redirect:/List";
	 * 
	 * }
	 */
	
	
}

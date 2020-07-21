package com.pknu.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.spring.vo.BoardVo;

@Controller
public class TempController {

	@RequestMapping("/")
	public String home() {
		return "home"; 
		/* viewResolver 이 있으면 그냥 home만 적어주면 된다. */
	}
	@RequestMapping("/temp1")
	public String temp1(HttpServletRequest request,HttpServletResponse response) {
		
		String a = request.getParameter("a");
		String b = request.getParameter("b");
		
		HttpSession session = request.getSession();
		session.getCreationTime(); 
		
		System.out.println("temp1");
		System.out.println(a);
		System.out.println(b);
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(a);
			out.print("  ");
			out.print(b);
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "none"; /* viewResolver 이 있으면 그냥 home만 적어주면 된다. */
	}
	@RequestMapping("/temp2") // /temp2?a=hello&b=2
	public String temp2(@RequestParam Map<String, String>map) {
		/* map은 a라는 key를 가진 hello 데이터와    b라는 키를 가진 2 value 
		 * map의 특징은 key를 통해 value를 도출하니깐 
		 * */
		
		String a = map.get("a"); 
		String b = map.get("b");
		System.out.println("temp2");
		System.out.println(a);
		System.out.println(b);
		
		return "none";
	}
	@RequestMapping("/temp3") // /temp2?a=hello&b=2
	public String temp3(@RequestParam("a") String a,@RequestParam("b") int b) {
	//public String temp3(String a,int b) {
		
		System.out.println("temp3");
		System.out.println(a);
		System.out.println(b);
		
		return "none";
	}
	@RequestMapping("/temp4") // temp4?a=hello&b=4
	public String temp4(BoardVo vo) {
		//얘는 RequestMapping가  temp4?a=hello&b=4 이것을 BoardVo에 알아서 set에 맞춰서 넣어준다.
		System.out.println("temp4");
		System.out.println(vo.getA());
		System.out.println(vo.getB());
		
		return "none";
	}
	
	@RequestMapping("/temp5") // /temp2?a=hello&b=2
	public String temp5(@RequestParam("a") String a, @RequestParam("b")int b,Model model) {
		
		//Model클래스 : 는 다른 페이지로 값을 전달하기 위해 담는객체
		System.out.println("temp5");
		System.out.println(a);
		System.out.println(b);
		
		//Model의 내용확인 : model안에는 자료가 map구조로 저장 
		Map<String, Object> map = model.asMap(); //여기서 앞에 <String,Object>는
		model.addAttribute("a",a); //여기 model.addAttribute("a",a)  앞에는 Stirng 뒤에는 object이다.
		model.addAttribute("b",b);
		model.addAttribute("Taehwa","28세입니다");
		//model객체는 key,value로 메소드를 이용하여 view 로 전달할 데이터를 key,value로 전달할 수 있습니다.
		//model.asMap(); 이뜻은 model 객체를 asMap()을 이용해 Map으로 변환하여 key값을 가져올 수 있다. 
		
		for (String key : map.keySet()) { //keySet() 메서드는 key의 값만 필요한 경우 사용합니다.
			System.out.println(key +"="+ map.get(key).toString());
		}
		return "none";
	}
	@RequestMapping("/temp6") // /temp2?a=hello&b=2
	public String temp6(BoardVo vo,Model model) {
		
		//Model클래스 : 는 다른 페이지로 값을 전달하기 위해 담는객체
		System.out.println("temp6");
		System.out.println(vo.getA());
		System.out.println(vo.getB());
		
		//Model의 내용확인 : model안에는 자료가 map구조로 저장 
		Map<String, Object> map = model.asMap();
		
		
		for (String key : map.keySet()) {
			System.out.println(key +"="+ map.get(key).toString());
		}
		return "none";
	}
	@RequestMapping("/temp7") // /temp2?a=hello&b=2
	public String temp7(@ModelAttribute("attrName") BoardVo vo,Model model) {
		
		//Model클래스 : 는 다른 페이지로 값을 전달하기 위해 담는객체
		System.out.println("temp7");
		System.out.println(vo.getA());
		System.out.println(vo.getB());
		
		//Model의 내용확인 : model안에는 자료가 map구조로 저장 
		Map<String, Object> map = model.asMap();
		
		for (String key : map.keySet()) {
			System.out.println(key +"="+ map.get(key).toString());
		}
		return "noneModel";
	}
	
	//PathVariable
	
	@RequestMapping("/temp8/{a}/{b}") // /temp2?a=hello&b=2
	public String temp8(@PathVariable("a") String a, @PathVariable("b") int b) {
		
		//Model클래스 : 는 다른 페이지로 값을 전달하기 위해 담는객체
		System.out.println("temp8");
		System.out.println(a);
		System.out.println(b);
		
		return "none";
	}
	
	@RequestMapping("/temp9/{a}/{b}") // /temp2?a=hello&b=2
	public String temp9(BoardVo vo ) {
		
		//Model클래스 : 는 다른 페이지로 값을 전달하기 위해 담는객체
		System.out.println("temp9");
		System.out.println(vo.getA());
		System.out.println(vo.getB());
		
		return "none";
	}
	
	@RequestMapping("/temp10/{a}/{b}") // /temp2?a=hello&b=2
	public String temp10(@ModelAttribute("attrName") BoardVo vo, Model model ) {
		//ModelAttribute는 vo안에 넣어줄 뿐만 아니라 Model 객체안에도 넣어준다.
		
		System.out.println("temp10");
		System.out.println(vo.getA());
		System.out.println(vo.getB());
		
		return "noneModel";
	}
	
	
}

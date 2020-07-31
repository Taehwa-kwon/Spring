package com.spring.board.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
//	@RequestMapping("/a")
//	public String html() {
//		return "redirect:/static/html/test01.html";
//	}
//	@RequestMapping("/b")
//	public String html2() {
//		return "redirect:/static/html/test02.html";
//	}
	
	@RequestMapping("/{value}")
	public String html(@PathVariable("value") String val) {
		String link="";
		
		switch(val) {
		case "a" : link="redirect:/static/html/test01.html"; break;
		case "b" : link="redirect:/static/html/test02.html"; break;
		case "c" : link="redirect:/static/html/test03.html"; break;
		case "d" : link="redirect:/static/html/test04.html"; break;
		case "e" : link="redirect:/static/html/test05.html"; break;
		case "f" : link="redirect:/static/html/test06.html"; break;
		}
		return  link;
	}
	
	@RequestMapping("/ajax")
	public void ajax(String v, HttpServletResponse response) {
		
		String json = "{" + 
                "   \"id\" : \"aaaa\"," + 
                "   \"pass\" :\"1234 \"," + 
                "   \"v\" : \"" + v + "\"" + 
                "}";
		//이게 JSON형태인 String json임 
		
		try {
			response.setContentType("application/json;charset=UTF-8"); 
			// application/json 은 json타입으로 보내준다는 의미 // 한글로 패치해준다.
			response.getWriter().print(json);
		} //서블릿에서 사용하는 문법getWriter() , jsp에 보내주는 문법..
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		
	}
	
	//@RequestBody     는 반드시 contentType: "application/json" 설정과  JSON.stringify  (Object 형태로 먼저 바꿔야함)
	//컨트롤러로 전송된 JSON 정보가 자동으로 Map으로 변환되어 해당 변수에 저장됩니다.

	
	@RequestMapping(value="/test1") //@RequestMapping("/test") 랑 같음
	@ResponseBody //map객체의 내용을 json으로 바꿔서 출력을 시켜준다.얘는 꼭 controller와 반드시 함께
	public Map<String,Object> test2(String id, String pass, String email){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",id);
		map.put("pass",pass);
		map.put("email",email);
		
		System.out.println("map 형태 : " + map);
		return map;
		
		
		}
	
//	@RequestMapping(value="/test") //@RequestMapping("/test") 랑 같음
//	@ResponseBody //map객체의 내용을 json으로 바꿔서 우리에게 출력을 시켜준다.얘는 꼭 controller와 반드시 함께
//	public  HashMap<String, Object> test3(@RequestBody HashMap<String,Object> map){
//		//RequestBody를 붙여주면 controller로 전송된 JSON정보를 자동으로 MAP으로 변환시켜서 해당 변수에 저장된다.
//		map.put("id","sky");
//		map.put("pass","blue");
//		return map;
//		
//		
//	}
	
	@RequestMapping(value="/test2")
	@ResponseBody
	public String test3() throws IOException{
//		List<BoardVo> list = new ArrayList<BoardVo>();
//		list = boardService.getList();
		List<BoardVo> list = boardService.getList();// daoImplement에서 값을 가져온다
		System.out.println("list 형태  : "+list);
		//위에꺼 2개를 합쳐서 적은게 바로 위에꺼 
		
		/*
		BoardVo vo = new BoardVo();
		vo.setEmail("aa");
		ArrayList list2 = new ArrayList();
		list2.add(new BoardVo(1,"id","abc@naver.com"));
		*/
		
//		list.add(new BoardVo(1,"제목1","abc@naver.com"));
//		list.add(new BoardVo(2,"제목2","abc@naver.com"));
		//컬렉션은 객체를 넣을수 있고 , 
		
		
		//Jackson Library
		//java 객체를 -> json으로 형태 변환 
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(list); //mapper.writeValueAsString을 하면  ->   "{"id":"aaa","pass":"1234", "email":"abc@naver.com" }"; 바뀌고 바로 json으로 못내려보내니깐  String으로 바뀐다 
		System.out.println("json형태인 String : "+jsonStr);
		
		
		
		//json -> java 객체 [List<>]
		//String jsonStr2 = "{"id":"aaa","pass":"1234", "email":"abc@naver.com" }";
		//BoardVo board = mapper.readValue(jsonStr2, BoardVo.class);
		//jsonStr2는 1개의 타입객체니깐 아래에서 BoardVo.class로 읽을수 있는데 
		//아래에서는 객체가 2개니깐 아래처럼 list에 새롭게 쌓는다.
		
		String jsonStr2 = "[" + 
				"	{ \"num\" : 1, \"id\" : \"권태화\" , \"email\" : \"abc@naver.com\" }," + 
				"	{ \"num\" : 2, \"id\" : \"태화\" , \"email\" : \"abc2@naver.com\" }" + 
				"]";
		List<BoardVo> list3 = mapper.readValue(jsonStr2, new TypeReference<List<BoardVo>>() {});
		System.out.println("json 형태 "+list3);
		
		
		System.out.println("json 형태인 0번째 : " + list3.get(0));
		System.out.println("json 형태인 1번째 : " + list3.get(1));
		
		
		
		return jsonStr;
		//return jsonStr2;
	}
	
	//====================================================================================
	@RequestMapping(value= "/getMovieJson")
	@ResponseBody
	public String getMovieJson() throws IOException {
		//BufferedReader //String 단위로 데이터를 받는다.
		//BufferedInputStream //byte단위로 데이터를 받는다
		BufferedInputStream reader = null;
		try {
		URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=794306f489b73e2728e234bc266fcd21&targetDt=20200701"); 
		//모든 입출력에 관해서는 throws를 해야한다.
		reader = new BufferedInputStream(url.openStream());
		StringBuffer buffer = new StringBuffer(); 
		//stringBuffer 쓰는 이유는 문자열이 오게되면 += 을 반복하게 되는데 그러면 속도가 늦어진다. 그래서 미리 공간을 만들어두고 문자열을 받아준다. 자세한건 검색
		// arrayList랑 비슷하대, 쓰레드가 오게되면 vector을 사용하는것과 같은 원리래
		
		int i ;
		byte [] b = new byte[4096];
		while ( (i=reader.read(b))!= -1) {
			buffer.append(new String(b,0,i));
			
		}
		return buffer.toString();
		} finally {
			if(reader !=null)
				reader.close();
		}
	}
	
	@RequestMapping(value= "/getMovieXml", produces="application/xml; charset=utf-8")
	@ResponseBody
	public String getMovieXml() throws IOException {
		//BufferedReader //String 단위로 데이터를 받는다.
		//BufferedInputStream //byte단위로 데이터를 받는다
		BufferedInputStream reader = null;
		try {
			URL url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=794306f489b73e2728e234bc266fcd21&targetDt=20200701"); 
			//모든 입출력에 관해서는 throws를 해야한다.
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer(); 
			//stringBuffer 쓰는 이유는 문자열이 오게되면 += 을 반복하게 되는데 그러면 속도가 늦어진다. 그래서 미리 공간을 만들어두고 문자열을 받아준다. 자세한건 검색
			// arrayList랑 비슷하대, 쓰레드가 오게되면 vector을 사용하는것과 같은 원리래
			
			int i ;
			byte [] b = new byte[4096];
			while ( (i=reader.read(b))!= -1) {
				buffer.append(new String(b,0,i));
			}
			System.out.println(buffer.toString());
			return buffer.toString();
			
		} finally {
			if(reader !=null)
				reader.close();
		}
	}
}
		
	


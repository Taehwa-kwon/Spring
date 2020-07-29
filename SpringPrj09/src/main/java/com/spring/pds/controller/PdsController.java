package com.spring.pds.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		//BOARD+FILES 테이블 조회 : menu_id 에 해당되는것을 조회한다.
		HashMap <String,Object> map = new HashMap<String,Object>();
		map.put("menu_id", vo.getMenu_id());
		List <PdsVo> pdsList = pdsService.getPdsList(map);
		
		//Menus테이블 조회 (사진,스포츠,유머)
		List<MenuVo>menuList = menuService.getList(map);
		
		//List.jsp 위한 준비
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pds/list");
		mv.addObject("menuList", menuList); //전체 메뉴 조회
		mv.addObject("pdsList", pdsList); //조회된 글
		
		return mv;
	}
		@RequestMapping("/PDS/WriteForm")
		public ModelAndView writeForm(PdsVo vo) {
			System.out.println("PdsController writeForm : " + vo);
			ModelAndView mv = new ModelAndView();

			HashMap <String,Object> map = new HashMap<String,Object>();
			map.put("menu_id", vo.getMenu_id());
			List<MenuVo>menuList = menuService.getList(map); //전체 메뉴 조회.
			mv.addObject("menuList", menuList);
			
			mv.addObject("pdsVo", vo);

			mv.setViewName("pds/write");
			return mv;
			
		}
		@RequestMapping("/PDS/Write")
		public ModelAndView wirte(PdsVo vo, HttpServletRequest request) {
			// write.jsp에서 파일을 넘길려면 enctype="multipart/form-data" 이 명령을 추가하고
			// pom.xml에서 MultippartHttpServletRequest 이 내용들을 추가해주고
			// 업로드 파일 사이즈를 늘리기 위해서 dispatcher-servlet 에서 설정을 추가해준다.
			
			//파일이 넘어올때는 vo가 잘라내지를 못한다(int,String등 기본형식만 가능) 바이너리 데이터를 받기 위해서는 넘어오는 정보에 개입을 해서 , 넘어오는 정보는 request니깐
			//넘어온 파일에 대해서 setWrite(map,request)로 넘겨준다.
			//insert의 장점이자 단점은 파일 업로드 하는순간 select 조차 아무것도 못한다. lock이 걸려버린다.
			//그런데 문제점은 5mb밖에 못하고 설정 변경을 통해서 용량을 늘릴수있다.
			//사진,영상을 DB에 insert하면 시간이 오래걸릴텐데 그 기간동안 아무도 DB에 접근을 못한다.
			//그것에 대한 정리는 ServiceImplement에서 처리한다.
			
			ModelAndView mv = new ModelAndView();
			HashMap <String,Object> map = new HashMap<>();
			map.put("menu_id", vo.getMenu_id());
			map.put("writer", vo.getWriter());
			map.put("title", vo.getTitle());
			map.put("cont", vo.getCont());
			map.put("bnum", vo.getBnum());
			map.put("lvl", vo.getLvl());
			map.put("step", vo.getStep());
			map.put("nref", vo.getNref());
			
			//글 저장
			pdsService.setWrite(map,request);
			
			//저장 이후 처리
			List<MenuVo>menuList = menuService.getList(map);
			System.out.println(menuList);
			
			mv.addObject("menu_id", vo.getMenu_id());
			mv.addObject("menuList", menuList);
			mv.setViewName("redirect:/PDS/List");
			return mv;
		}//write
		
		
		//다운로드 시작
		//{sfile}		: .jpg와 같이 .포함 글자는 무시. 다운안받는다.
		//{sfile:.+} 	: 정규식! 확장자에 .문자가 한개 이상일때  , 즉 점이 있는것만,(확장자) 다운받겠습니다~ 즉 점이 무조건 하나이상이여야 함. 그런 애들만RequestMapping이 가능하다. 
		//method = get방식만 가능하게 제한하는것.
		
							// /download/external/${pdsVo.filename }
		@RequestMapping(value="/download/{type}/{sfile:.+}",method=RequestMethod.GET)
		public void downloadFile(HttpServletResponse response,
					@PathVariable("type")String type,//{} 템플릿변수
					@PathVariable("sfile")String sfile
				) {
			String INTERNAL_FILE = sfile; //내부 파일 명 
			String EXTERNAL_FILE_PATH = "h:\\Upload\\"+ sfile; //외부 파일경로 + 파일명
			File file = null;
			if(type.equalsIgnoreCase("internal")) {
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				//ClassLoader은 이 전체 현재 클래스   currentThread 현재 실행중인 쓰레드 그 클래스 정보를 가져온나.
				file = new File(classLoader.getResource(INTERNAL_FILE).getFile()); 
				//이 위치정보를 가져와서 , getFile 그 파일을 가져온나.
				//현재 실행중인 폴더에 있는것을 사용하는것이 internal. 
			} else {
				file = new File(EXTERNAL_FILE_PATH);
			}
			
			//다운로드할 파일이 없습니다.
			if(!file.exists()) {
				String errorMessage = "다운로드할 파일이 없습니다.";
				//이럴때는 HTML로 내 보내야한다. 이 error은 db에 저장되어 있는데 하드디스크에 저장되어 있지 않는 경우, 해당 오류가 발생
				
				//out.print(); //response.getWrite를 해야한다. 그래야 out이 가능하다.
				OutputStream outputStream = null;
				try {
					outputStream = response.getOutputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
					//이 함수는 byte단위로 파일을 처리해야 한다. 웹은 모든 데이터를 byte단위로 처리한다.
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
				
			}
			/* 
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			//이 파일의 타입이 뭐냐, text면 text로 인식하고 바로 인식해라. excel이면 excel을 
			if(mimeType==null) {
				mimeType="application/octet-stream";
			}
			 * 여기서 하려고 하는게 자료실이잖아. 내가 원하는 파일을 다운받으려고 하는데 excel이면 내 컴퓨터에 excel이 있으면 다운로드 안하고
			 * 바로 파일을 브라우저에서 excel형식으로 실행을 해버린다. 
			 * 브라우저에게 다운받을 파일의 type을 알려주고, 찾아준다. 
			*/
			String mimeType="application/octet-stream";
			//그래서 이러한 코딩을 통해서 파일을 무조건 다운로드 하여라
			
			
	//다운로드 로직 start		
			response.setContentType(mimeType);
			response.setHeader("Content-Dispostition", String.format("inline; filename=\""+file.getName()+"\""));
			//filename은 ""안에 넣어야하는데 \" 이렇게 해야 들어감.
			response.setContentLength((int)file.length());
			InputStream inputStream = null;
			try {
				inputStream = new BufferedInputStream(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				FileCopyUtils.copy(inputStream, response.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//이 내용이 핵심문장이다.  copy는 byte단위로 해서 다 copy하고 close both streams < 이렇게 하면 inputStream.close() outputStream.close() 둘다 생략이 가능하다.
		
		}
		
		@RequestMapping("/PDS/View") // PDS/View?idx=8&bnum=1&lvl=0$step=1$nref=1$menu_id=MENU01
		public ModelAndView view(PdsVo vo) {
			
			HashMap<String,Object>map = new HashMap<String,Object>();
			map.put("idx",vo.getIdx());
			
			
			List<PdsVo> ViewList =  pdsService.getView(map); 
			List<MenuVo>menuList = menuService.getList(map);
			ModelAndView mv = new ModelAndView();
			mv.addObject("menuList", menuList);
			mv.addObject("pdsVo",ViewList.get(0) );
			
			mv.setViewName("pds/content");
			return mv;
		}
		
		
		
}

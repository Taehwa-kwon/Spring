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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

//@RequestMapping("/PDS") 이렇게하면 Mapping에서 /PDS로 묶을수 있다. 그러면 다운로드 로직에서 문제가 발생하긴함.

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
		
		// /PDS/List?menu_id=MENU01&nowpage=1&pagecount=2&pagegrpnum=1
		ModelAndView mv = new ModelAndView();

		List<PdsVo> pdsList = pdsService.getList(map);
		List<MenuVo> menuList = menuService.getList(map);
		
		mv.addObject("map", map);//여기는 menus.jsp에 content와 list의 menus.jsp안에 그 페이지번호를 넘겨주기 위해서 묶어두는것
		PdsVo pagePdsVo = (PdsVo)map.get("pagePdsVo");
		
		mv.addObject("menuList", menuList); //메뉴목록
		mv.addObject("pdsList", pdsList); //게시글 목록
		
		mv.addObject("pagePdsVo",pagePdsVo); //페이지 정보들
		mv.addObject("menu_id", map.get("menu_id"));
		/*
		System.out.println("========================================");
		System.out.println("PdsController 가장 중요한 핵심 인듯.. : "+map);
		System.out.println("menu_id는 home.jsp에서 a태그로 받은것");
		System.out.println("result는 에서 menuList에서 받은것");
		System.out.println("pagePdsVo는 PdsServiceImplement에서 받은것");
		System.out.println("=========================================");
		*/
		/*    list.jsp 에 있는 a태그 맨뒤에 ?a=${param.a} 이렇게 해서 */
		
		
		mv.setViewName("pds/list");
		return mv;
	}

	@RequestMapping("/PDS/WriteForm")
	public ModelAndView writeForm(@RequestParam HashMap<String, Object> map) {
		List<MenuVo> menuList = menuService.getList(map);

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
		
		pdsService.setWrite(map, request);
		
		ModelAndView mv = new ModelAndView();
		
		List<MenuVo> menuList = menuService.getList(map);
		mv.addObject("menuList", menuList);

		mv.addObject("menu_id", map.get("menu_id"));
		
		/*페이징 관련 처리*/
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		mv.addObject("pagecount", map.get("pagecount"));
		
		mv.setViewName("redirect:/PDS/List");
		return mv;

	}
	
	//idx&menu_id&nowpage&pagegrpnum 를 가져온다.
	@RequestMapping("/PDS/Content") //list.jsp에서 a태그 안의 내용
	public ModelAndView content(@RequestParam HashMap<String,Object>map ) {
		ModelAndView mv = new ModelAndView();
		PdsVo pdsVo = pdsService.getContent(map);  //게시글 조회
		List<MenuVo> menuList = menuService.getList(map); //메뉴조회
		List<FilesVo> fileList = pdsService.getFileList(map);//게시글의 파일 목록조회
		
		System.out.println("pdscontent의 pdsVo : " + pdsVo);
		System.out.println("pdscontent의 map : " + map);
		
		mv.addObject("menuList", menuList);
		mv.addObject("pdsVo", pdsVo);
		mv.addObject("fileList", fileList);
		
		mv.addObject("map", map);//여기는 menus.jsp에 content와 list의 menus.jsp안에 그 페이지번호를 넘겨주기 위해서 묶어두는것
		
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		
		mv.setViewName("pds/content");
		
		
		return mv;
		
	}
	
	@RequestMapping("/PDS/UpdateForm")
	public ModelAndView updateForm(@RequestParam HashMap<String, Object>map) {
		ModelAndView mv = new ModelAndView();
		List<MenuVo> menuList = menuService.getList(map);
		PdsVo pdsVo = pdsService.getContent(map);
				
		mv.addObject("map", map);
		mv.addObject("menuList", menuList);
		mv.addObject("pdsVo",pdsVo);

		mv.addObject("nowpage",map.get("nowpage"));
		mv.addObject("pagecount",map.get("pagecount"));
		mv.addObject("pagegrpnum",map.get("pagegrpnum"));
		
		System.out.println("updateform의 pdsVO : " + pdsVo);
		System.out.println("updateform의 map : " + map);
		
		mv.setViewName("pds/update");
		return mv;
	}
	
	@RequestMapping("/PDS/Update")
	public ModelAndView update(@RequestParam HashMap<String, Object>map) {
		ModelAndView mv = new ModelAndView();
		List<MenuVo> menuList = menuService.getList(map);
		
		pdsService.setUpdate(map);
		
		mv.addObject("map", map);
		mv.addObject("menuList", menuList);
		
		/*페이징 관련 처리*/
		mv.addObject("nowpage", map.get("nowpage"));
		mv.addObject("pagegrpnum", map.get("pagegrpnum"));
		mv.addObject("pagecount", map.get("pagecount"));
		
//		mv.setViewName("redirect:/PDS/List?pagecount=2&nowpage=3&pagegrpnum=1&menu_id=MENU01");
		mv.setViewName("redirect:/PDS/List?pagecount="+map.get("pagecount") + "&nowpage="+map.get("nowpage")+"&pagegrpnum="+map.get("pagegrpnum")+"&menu_id="+map.get("menu_id") );
		System.out.println("pdsupdate의  map : " + map);
		return mv;
	}
	
	@RequestMapping("/PDS/Delete")
	public ModelAndView pdsDelete(@RequestParam HashMap<String,Object>map) {
		ModelAndView mv = new ModelAndView();
		
		//삭제
		pdsService.setDelete(map);
		
		mv.setViewName("redirect:/PDS/List?pagecount="+map.get("pagecount") + "&nowpage="+map.get("nowpage")+"&pagegrpnum="+map.get("pagegrpnum")+"&menu_id="+map.get("menu_id") );
		return mv;
	}
	
	
	
	
	// 다운로드 시작
	// {sfile} : .jpg와 같이 .포함 글자는 무시. 다운안받는다.
	// {sfile:.+} : 정규식! 확장자에 .문자가 한개 이상일때 , 즉 점이 있는것만,(확장자) 다운받겠습니다~ 즉 점이 무조건
	// 하나이상이여야 함. 그런 애들만RequestMapping이 가능하다.
	// method = get방식만 가능하게 제한하는것.

	// /download/external/${pdsVo.filename }
	@RequestMapping(value = "/download/{type}/{sfile:.+}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, 
			@PathVariable("type") String type, // {} 템플릿변수
			@PathVariable("sfile") String sfile) {
		String INTERNAL_FILE = sfile; // 내부 파일 명
		String EXTERNAL_FILE_PATH = "h:\\Upload\\" + sfile; // 외부 파일경로 + 파일명
		File file = null;
		if (type.equalsIgnoreCase("internal")) {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			// ClassLoader은 이 전체 현재 클래스 currentThread 현재 실행중인 쓰레드 그 클래스 정보를 가져온나.
			file = new File(classLoader.getResource(INTERNAL_FILE).getFile());
			// 이 위치정보를 가져와서 , getFile 그 파일을 가져온나.
			// 현재 실행중인 폴더에 있는것을 사용하는것이 internal.
		} else {
			file = new File(EXTERNAL_FILE_PATH);
		}

		// 다운로드할 파일이 없습니다.
		if (!file.exists()) {
			String errorMessage = "file not exists";
			// 이럴때는 HTML로 내 보내야한다. 이 error은 db에 저장되어 있는데 하드디스크에 저장되어 있지 않는 경우, 해당 오류가 발생

			// out.print(); //response.getWrite를 해야한다. 그래야 out이 가능하다.
			OutputStream outputStream = null;
			try {
				outputStream = response.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
				// 이 함수는 byte단위로 파일을 처리해야 한다. 웹은 모든 데이터를 byte단위로 처리한다.
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
		 * String mimeType = URLConnection.guessContentTypeFromName(file.getName()); //이
		 * 파일의 타입이 뭐냐, text면 text로 인식하고 바로 인식해라. excel이면 excel을 if(mimeType==null) {
		 * mimeType="application/octet-stream"; } 여기서 하려고 하는게 자료실이잖아. 내가 원하는 파일을 다운받으려고
		 * 하는데 excel이면 내 컴퓨터에 excel이 있으면 다운로드 안하고 바로 파일을 브라우저에서 excel형식으로 실행을 해버린다.
		 * 브라우저에게 다운받을 파일의 type을 알려주고, 찾아준다.
		 */

		String mimeType = "application/octet-stream";
		// 그래서 이러한 코딩을 통해서 파일을 무조건 다운로드 하여라

		// 다운로드 로직 start
		response.setContentType(mimeType);
		response.setHeader("Content-Dispostition", String.format("inline; filename=\"" + file.getName() + "\""));
		// filename은 ""안에 넣어야하는데 \" 이렇게 해야 들어감.
		response.setContentLength((int) file.length());
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
		// 이 내용이 핵심문장이다. copy는 byte단위로 해서 다 copy하고 close both streams < 이렇게 하면
		// inputStream.close() outputStream.close() 둘다 생략이 가능하다.

	}

}

package com.spring.pds.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.FilesVo;
import com.spring.pds.vo.PdsVo;

@Service("pdsService") //id는 주는게 원칙이다.
public class PdsServiceImplement implements PdsService {

	@Autowired
	private PdsDao pdsDao;
	
	@Override
	public List<PdsVo> getList(HashMap<String, Object> map) {
		int pagetotalcount = 3; // 한 그룹에 몇개의 한 페이지당 총 개수 
		int pagecount = Integer.parseInt((String) map.get("pagecount")); //한 페이지당 n 라인
		//int pagecount = 2; //한 페이지당 n 라인
		List<PdsVo> pdsList = pdsDao.getList(map);
		
		/* pagecount, nowpage, pagegrpnum은 home.jsp에서 a태그 뒤에 파라메터로 온다  getParameter이니깐 String으로 받는다.
		 * 그래서 이렇게 형 변환을 한다. (Integer.parseInt, valueOf 모두 같음)
		 * 비교vs비교
		 * recordcount는 mapper에서 보면 jdbcType이 integer이니깐 
		 *   */
		int nowpage = Integer.valueOf((String) map.get("nowpage")); //현재 페이지정보 
		int pagegrpnum = Integer.valueOf((String) map.get("pagegrpnum")); //그룹넘버 
		
		int recordcount = (int) map.get("recordcount"); // recordcount  전체 게시글 수
		
		BoardPaging bp = new BoardPaging (nowpage , pagecount, recordcount,pagetotalcount, pagegrpnum);
		
		PdsVo vo = bp.getPdsPagingInfo();
		vo.setMenu_id((String)map.get("menu_id"));
		
		map.put("pagePdsVo",vo);
		
		return pdsList;
	}

	@Override
	public void setWrite(HashMap<String, Object> map, HttpServletRequest request) {
		//1.파일업로드 비즈니스 로직 처리		
		CheckFileName checkFile = new CheckFileName();
		

		String filePath="h:\\Upload\\";
		//업로드된 파일이 저장될 경로 지정
		// service 는 DB와 관련되지 않는 내용을 처리한다.파일 업로드는 DB와 관련없다. 
		// repository, CRUD는 DB와 관련된 정보. DAO에는 CRUD에 관련된 내용만
		
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request; 
		//파일에 관련된 객체에 짚어넣는다. 이 변수를 통해서 파일을 조작할수 있다.
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		//for문의 i 가 iterator의 i 이다 . iterator은 반복자라는 의미 , 어떤 손가락을 의미한다.
		//여러개 파일이 넘어오면 그것을 처리 위해서 iterator을 사용한다. 넘어온 파일들의 이름들 getFileNames();
		//write.jsp에서 여러개의 파일들을 넘겨줘도 iterator을 통해서 다 처리가 가능하다.
		
		MultipartFile multipartFile = null;
		
		//여러개의 파일 처리
		List<String> fileNames = new ArrayList<String>();
		List<String> fileExts = new ArrayList<String>();
		List<String> sFileNames = new ArrayList<String>();
		//배열은 초기에 갯수를 정해줘야 하는데 ArraryList는 동적으로 변하니깐 ArrayList를 사용한다.
	    
	      String fileName = null;
	      String orgFileName = null;
	      String fileExt = null;
	      String sFileName = null;

		
		while(iterator.hasNext()) {
			//반복자에 대해서 자료가 있는지 없는지를 묻는거고 true이면 아래로 간다.
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			//next는 현재줄을 읽고 다음줄로 가라, 인데 현재 파일을 읽어와서 그것을 multipartFile로 지정해라. 
			
			if(!multipartFile.isEmpty()) {
				//그 파일이 있는지 없는지 확인하고, 있다면 !not을 붙이고
				fileName = multipartFile.getOriginalFilename();
				
				orgFileName = fileName.substring(0,fileName.lastIndexOf("."));
				// . 앞에까지가 파일 이름이고
				fileExt = fileName.substring(fileName.lastIndexOf("."));
				// .을 포함해서 뒤에 내용가져오고

				sFileName = checkFile.getFileName(filePath,orgFileName, fileExt);
				//fileName으로 저장된 폴더에서 중복된 파일이 있는경우 처리.
				//만약에 같은 파일을 업로드 했을경우 계속 엎어쓰기가 되니깐 그것을 처리하기 위해서 새로운 클래스를 만들어줌.
				
				fileNames.add(fileName); // ArrayList에 추가
				fileExts.add(fileExt); // ArrayList에 추가
				sFileNames.add(sFileName); // ArrayList에 추가
				
				map.put("filename", fileNames); //파일이름
				map.put("fileext", fileExts); //확장자이름
				map.put("sfilename", sFileNames); //전체 이름
				
				
				File file = new File(filePath+sFileNames);
				
				
				//multipartFile.transferTo(file); try catch
				try {
					multipartFile.transferTo(file);
					//이 부분에서 파일을 저장한다.
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}//if
			
		}//while
		
		System.out.println("db저장 전에 들어가는 map"+map);
		//2.DB에 저장		
		pdsDao.setWrite(map);
		
	}//setWrite

	@Override
	public PdsVo getContent(HashMap<String, Object> map) {
		//List<PdsVo> pdsList =pdsDao.getContent(map);
		PdsVo vo =pdsDao.getContent(map);
		
		
		return vo;
	}

	@Override
	public List<FilesVo> getFileList(HashMap<String, Object> map) {
			List<FilesVo> filelist =pdsDao.getFileList(map);
		return filelist;
	}

	@Override
	public void setUpdate(HashMap<String, Object> map) {
		pdsDao.setUpdate(map);
		
	}

	@Override
	public void setDelete(HashMap<String, Object> map) {
		pdsDao.setDelete(map);
		
	}

		

	

}

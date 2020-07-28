package com.spring.pds.service.impl;

import java.io.File;
import java.io.IOException;
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
import com.spring.pds.vo.PdsVo;

@Service("pdsService") //id는 주는게 원칙이다.
public class PdsServiceImplement implements PdsService {

	@Autowired
	private PdsDao pdsDao;
	
	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		List<PdsVo> pdsList = pdsDao.getPdsList(map);
		return pdsList;
	}

	@Override
	public void setWrite(HashMap<String, Object> map, HttpServletRequest request) {
		
		CheckFileName checkFile = new CheckFileName();
		

		String filePath="h:\\Upload\\";
		//업로드된 파일이 저장될 경로 지정
		// service 는 DB와 관련되지 않는 내용을 처리한다.파일 업로드는 DB와 관련없다. 
		// repository, CRUD는 DB와 관련된 정보. DAO에는 CRUD에 관련된 내용만
		
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request; 
		//파일에 관련된 객체에 짚어넣는다. 이 변수를 통해서 파일을 조작할수 있다.
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		//for문의 i 가 iterator의 i 이다 . iterator은 반복자라는 의미 
		//여러개 파일이 넘어오면 그것을 처리 위해서 iterator을 사용한다. 넘어온 파일들의 이름들 getFileNames();
		//write.jsp에서 여러개의 파일들을 넘겨줘도 iterator을 통해서 다 처리가 가능하다.
		
		MultipartFile multipartFile = null;
		
		String fileName = null; //파일명 ABC.jpg
		String orgFileName = null; //ABC
		String fileExt = null; //.jpg
		String sFileName = null; // 서버에서 사용자들을 구별해서..
		
		
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
				
				File file = new File(filePath+sFileName);
				
				//multipartFile.transferTo(file); try catch
				try {
					multipartFile.transferTo(file);
					//파일저장
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}//if
			
		}//while
		map.put("filename", fileName);
		map.put("fileext", fileExt);
		map.put("sfilename", sFileName);

		
		pdsDao.setWrite(map);
		
	}//setWrite

}

package com.spring.pds.service.impl;

import java.io.File;

public class CheckFileName {

	public String getFileName(String filePath, String orgFileName, String fileExt) {
		
		boolean isCheck = true;
		String returnFileName = null;

		String fullFilePath = null;
		File file = null;
		
		int i = 0;
		while( isCheck ) {
			fullFilePath = filePath + orgFileName + fileExt;
			file = new File(fullFilePath);
			if(file.exists()) { 
				//파일의 존재여부를 판단 exists() < 
				i +=1;
				//있으면 +1 증가.
				orgFileName = orgFileName +String.valueOf(i);
				//ABC1  <<이렇게 숫자를 증가시키려고
			}
			else 
			{
				isCheck = false;
			}
		}
		returnFileName= orgFileName + fileExt;
		//확장자 붙이기
		return returnFileName;
		
	}

	
}

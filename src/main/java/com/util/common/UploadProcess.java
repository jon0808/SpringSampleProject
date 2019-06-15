package com.util.common;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class UploadProcess {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadProcess.class);
   /** 업로드 프로세스
	* (파일 업로드 처리)
	* @return res
	*/
	@SuppressWarnings("rawtypes")
	public static Map uploadProcess(HttpServletRequest request, String path) {
		//파일이 저장될 path 설정 
		Map returnObject = new HashMap();
		try { 
			// MultipartHttpServletRequest 생성 
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			Iterator iter = mhsr.getFileNames();
			MultipartFile mfile = null;
			String fieldName = "";
			List resultList = new ArrayList(); 
			
			// 디레토리가 없다면 생성 
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs(); 
			} 
			
			// 값이 나올때까지
			while (iter.hasNext()) { 
				fieldName = (String) iter.next(); // 내용을 가져와서
				mfile = mhsr.getFile(fieldName); 
				String origName; 
				origName = new String(mfile.getOriginalFilename()); //한글꺠짐 방지 
				
				// 파일명이 없다면 
				if ("".equals(origName)) { 
					continue; 
				} 
				// 파일 명 변경(uuid로 암호화) 
				String ext = origName.substring(origName.lastIndexOf('.')); // 확장자
				String saveFileName = getUuid() + ext; 
				// 설정한 path에 파일저장
				File serverFile = new File(path + File.separator + saveFileName); 
				mfile.transferTo(serverFile);
				
				Map file = new HashMap();
				file.put("origName", origName);
				file.put("sfile", serverFile);
				resultList.add(file);
			} 
			
			returnObject.put("files", resultList); 
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch (IllegalStateException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		
		return returnObject; 
	}
	//uuid생성
	public static String getUuid() { 
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
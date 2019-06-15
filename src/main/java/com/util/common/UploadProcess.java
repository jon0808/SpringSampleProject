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
   /** ���ε� ���μ���
	* (���� ���ε� ó��)
	* @return res
	*/
	@SuppressWarnings("rawtypes")
	public static Map uploadProcess(HttpServletRequest request, String path) {
		//������ ����� path ���� 
		Map returnObject = new HashMap();
		try { 
			// MultipartHttpServletRequest ���� 
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
			Iterator iter = mhsr.getFileNames();
			MultipartFile mfile = null;
			String fieldName = "";
			List resultList = new ArrayList(); 
			
			// ���丮�� ���ٸ� ���� 
			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs(); 
			} 
			
			// ���� ���ö�����
			while (iter.hasNext()) { 
				fieldName = (String) iter.next(); // ������ �����ͼ�
				mfile = mhsr.getFile(fieldName); 
				String origName; 
				origName = new String(mfile.getOriginalFilename()); //�ѱۃ��� ���� 
				
				// ���ϸ��� ���ٸ� 
				if ("".equals(origName)) { 
					continue; 
				} 
				// ���� �� ����(uuid�� ��ȣȭ) 
				String ext = origName.substring(origName.lastIndexOf('.')); // Ȯ����
				String saveFileName = getUuid() + ext; 
				// ������ path�� ��������
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
	//uuid����
	public static String getUuid() { 
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
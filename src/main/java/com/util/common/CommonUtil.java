package com.util.common;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

public class CommonUtil {
	
   /** ip���� �޼ҵ�
	* (������ ������� ip�� ������ �´�.)
	* @return ip
	*/
	public static String ipInfo() {
		// RequestContextHolder�� ���� HttpServletRequest ȹ��
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		//HTTP Header�� X-Forwarded-For ���� Ȯ��
		String ip = req.getHeader("X-FORWARDED-FOR");
			// ip�� null�̸� getRemoteAddr() ���
			if (ip == null)
				ip = req.getRemoteAddr(); // ȣ��
		return ip;   
	}
	   
   /** ��¥ �� �ð� ���
	* 
	* @return today
	*/
	public static String todayInfo() {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date.format(d).toString();   
	}
	   
   /** ip ���� Log ���
	* 
	* @return iptodayInfo
	*/
	public static String ipInfoLog(HttpServletRequest request) {
		String ipInfoLog = "[" + ipInfo() + "]";
		return ipInfoLog;   
	}
	   
	/** �����޽����� String���� ��ȯ
	 *
	 * @param e
	 * @return
	 */
	public static String getPrintStackTrace(Exception e) {
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));        
        return errors.toString();     
    }

}
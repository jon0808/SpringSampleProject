package com.util.common;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

public class CommonUtil {
	
   /** ip정보 메소드
	* (접속한 사용자의 ip를 가지고 온다.)
	* @return ip
	*/
	public static String ipInfo() {
		// RequestContextHolder를 통해 HttpServletRequest 획득
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		//HTTP Header인 X-Forwarded-For 값을 확인
		String ip = req.getHeader("X-FORWARDED-FOR");
			// ip가 null이면 getRemoteAddr() 사용
			if (ip == null)
				ip = req.getRemoteAddr(); // 호출
		return ip;   
	}
	   
   /** 날짜 및 시간 출력
	* 
	* @return today
	*/
	public static String todayInfo() {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date.format(d).toString();   
	}
	   
   /** ip 정보 Log 출력
	* 
	* @return iptodayInfo
	*/
	public static String ipInfoLog(HttpServletRequest request) {
		String ipInfoLog = "[" + ipInfo() + "]";
		return ipInfoLog;   
	}
	   
	/** 에러메시지를 String으로 변환
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
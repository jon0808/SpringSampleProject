<%@page import="com.util.common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String errorMsg = session.getAttribute("ERROR_MSG").toString();
	log("ERROR_MSG : " + errorMsg);
	out.write("<script language='JavaScript'>");
	out.write("alert('세션이 종료되어 로그인 페이지로 이동합니다');");
	out.write("if (top.opener) {");
	out.write("		top.close();");
	out.write("		top.opener.top.location.href = '/index.do';");
	out.write("}else{");
	out.write("		top.location.href = '/index.do';");
	out.write("}</script>");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
</head>
<body>
	error
</body>
</html>
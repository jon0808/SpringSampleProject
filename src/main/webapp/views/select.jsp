<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>selectSample</title>
</head>
<body>
<h1>
	list  
</h1>
<c:forEach var="vo" items="${list }">
<P>${vo.deptNo } ${vo.deptName }</P>
</c:forEach>

</body>
</html>

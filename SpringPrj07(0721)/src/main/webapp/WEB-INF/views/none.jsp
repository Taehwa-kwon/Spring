<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${Taehwa}
	<p><%request.getParameter("a"); %></p>
	<p><%request.getAttribute("a"); %></p>
	


</body>
</html>
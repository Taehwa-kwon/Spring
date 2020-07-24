<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href ="/css/common.css"/>

</head>
<body>
	<form action="/Menus/Update" method="POST">
		
	<c:forEach var="menuVo" items="${Update }">
		<input type="text" name="menu_id" readonly value="${menuVo.menu_id }"/><br>
		<input type="text" name="menu_name" value="${menuVo.menu_name }" /><br>
		<input type="text" name="menu_seq" value="${menuVo.menu_seq }"/><br>
		<input type="submit" value="수정"/>
	</c:forEach>
		
	</form>
</body>
</html>
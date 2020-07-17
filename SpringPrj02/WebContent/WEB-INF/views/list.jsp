<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
taglib 디렉티브는 표현 언어(EL : Expression Language), 
JSTL(JSP Standard Tag Library), 
커스텀 태그(Custom Tag)를 JSP 페이지 내에 사용할 때 사용된다.


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List 회원목록</h1>

	<c:forEach var="user" items="${ userList }"> <!-- UserController.java로 받아온다. -->
		<ul>
			<li>이름:${user.name }</li>
			<li>전화: <a href="/View?tel=${user.tel }">${user.tel }</a></li> <!-- 개인조회하기 위해서 a 태그를 달아준다. -->
		</ul>
	</c:forEach>
	
	<p/>
	<a href="/WriteForm">글쓰기</a>
</body>
</html>
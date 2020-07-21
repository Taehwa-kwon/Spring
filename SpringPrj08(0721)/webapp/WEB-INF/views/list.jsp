<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>목록보기</h2>
	<table>
	<tr>
	<th>번호</th>
	<th>제목</th>
	<th>이름</th>
	<th>날짜</th>
	</tr>
	
	<c:forEach var="board" items="${boardList }">
	<td>${board.idx}</td>
	<td>${board.title}</td>
	<td>${board.name}</td>
	<td>${board.regdate}</td>
	</c:forEach>
	</table>
	<a href="/Board/WriteForm">새글쓰기</a>
	<a href="/">Main page</a>
	
	
</body>
</html>
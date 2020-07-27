<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href ="/css/common.css"/>
<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">

</head>
<body>
	<h1>Board 목록(list)</h1>
	<a href="/Board/WriteForm">새 글 쓰기 </a>
	<table>
		<tr style="background-color:rgba(255, 255, 128, .5)">
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>조회수</th>
			<th></th>
			<th></th>
		</tr>
	<c:forEach var="board" items="${boardList }">
		<tr>
			<th>${board.idx }</th>
			<th>${board.title }</th>
			<th>${board.name }</th>
			<th>${board.regdate }</th>
			<th>${board.count }</th>
			<th><a href="/Board/UpdateForm?idx=${board.idx }">수정</a></th>
			<th><a href="/Board/Delete?idx=${board.idx }">삭제</a></th>
		</tr>
	</c:forEach>
	</table>
	
	
</body>
</html>
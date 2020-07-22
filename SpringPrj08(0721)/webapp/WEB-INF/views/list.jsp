<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   table, th, td{border:1px solid black; border-collapse:collapse; text-align:center;}
   table{width:500px; margin:0 auto;}
   td:nth-of-type(1) {width:100px;}
   td:nth-of-type(2) {width:100px;}
   td:nth-of-type(3) {width:100px;}
   td:nth-of-type(4) {width:100px;}
</style>

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
			<tr>
				<td>${board.idx}</td>
				<!-- vo 안에 getter setter이 있어야 하는 이유는 $ 해서 쓰면 getIdx 를 가져온다 -->
				<td><a href="/Board/Content?idx=${board.idx }">${board.title}</a></td>
				<td>${board.name}</td>
				<td>${board.regdate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/Board/WriteForm">새글쓰기</a>
	<a href="/">Main page</a>


</body>
</html>
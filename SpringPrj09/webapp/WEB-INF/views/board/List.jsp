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

	<table>
		<tr style="background-color: rgba(255, 255, 128, .5)">
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.idx }</td>
				<td>${board.title }</td>
				<td>${board.name }</td>
				<td>${board.regdate }</td>
				<td>${board.count }</td>
				<td><a href="/Board/UpdateForm?idx=${board.idx }">수정</a></td>
				<td><a href="/Board/Delete?idx=${board.idx }">삭제</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="7">
				<a  href="/Board/WriteForm">새 글 쓰기 </a> 
				<a	href="javascript:history.go(-1)">back</a> 
				<a	href="javascript:history.reload()">reload</a> 
				<a	href="javascript:history.go(1)">go</a>
			</td>
		</tr>
	</table>


</body>
</html>
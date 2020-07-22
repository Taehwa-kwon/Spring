<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel ="stylesheet" href ="/css/common.css"/>
<!-- 외부스타일 부르기 방법 ! 
근데 경로도 매우 중요. 사실 WebContent밑에 css폴더가 와야하는데
지금은 WEB-INF밑에 resources - css - 밑에 commons.css파일이 있다.
dispatcher-servlet파일에도 해당 설정을 추가해야 한다.

-->

<style>
	h2 {text-align:center;}
   td:nth-of-type(1) {width:80px;}
   td:nth-of-type(2) {width:200px;}
   td:nth-of-type(3) {width:80px;}
   td:nth-of-type(4) {width:340px;}
   td:nth-of-type(5) {width:100px;}
   .atag{text-align:center;}
</style>

</head>
<body>
	<h2>list목록보기</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.idx}</td>
				<!-- vo 안에 getter setter이 있어야 하는 이유는 $ 해서 쓰면 getIdx 를 가져온다 -->
				<td><a href="/Board/Content?idx=${board.idx }">${board.title}</a></td>
				<td>${board.name}</td>
				<td>${board.regdate}</td>
				<td>${board.count}</td>
			</tr>
		</c:forEach>
	</table>

	<div class="atag">
		<a href="/Board/WriteForm">새글쓰기</a>
		<a href="/">Main page</a>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>새글 쓰기</h1>
	<a href="javascript:history.back()">뒤로</a> <!-- 뒤로가는 자바 스크립트 문법 -->
	<a href="/Board/List">목록보기</a>
	
	<form action="/Board/Write" method= "POST">
		제목 <input type="text" name="title" /> <br>
		이름 <input type="text" name="name" /> <br>
		<input type="submit" value="저장">
	</form>
</body>
</html>
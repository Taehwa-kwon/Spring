<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>수정</h2>

<form action="/Board/Update">
<input type="text" name="idx" value="${update.idx }">번호 
<!-- $태그쓸떄 Vo의 get메소드가 발생함 -->
<input type="text" name="title">제목
<input type="text" name="name">이름
<input type="text" name="regdate">날짜
<input type="submit" value="저장">
</form>			
	
	
	<a href="javascript:history.back()">뒤로</a>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/loginProcess" method="POST">
		<div> <input type="text" name="userId" placeholder="아이디"></div>
		<div> <input type="text" name="userPw" placeholder="비밀번호"></div>
		<div> <input type="submit" value="로그인"></div>
	</form>
</body>
</html>
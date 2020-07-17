<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Write.jsp 새글 쓰기</h1>
	<form action="/Write" method="GET">
		이름 : <input type="text" id="" name="name" value=""/><br/> 
		전화 : <input type="text" id="" name="tel" value=""/><br/>
		<input type="submit" value="저장"/> <br/>
	</form>
</body>
</html>
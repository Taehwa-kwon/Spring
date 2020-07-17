<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home JSP 테스트</h1>
	<p/>
	${age} 살입니다.
	<%-- <%=model.getAttribute("age")  %> --%>
	
	<!-- <a href="/SpringPrj02/List">목록보기</a> -->
	<a href="/List">목록보기</a>
	<a href="/WriteForm">새글쓰기</a>
</body>
</html>
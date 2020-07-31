<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel ="stylesheet" href ="/css/common.css"/>
<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">

<html>
<head>
<meta charset="UTF-8">
<title>BoardMainPage</title>
</head>
<body>
	<h1 class="blinking"> BoardMainPage </h1>
	<p ><a href="/Board/List" >게시판</a></p>
	<p><a href="/Board/WriteForm">새글 쓰기</a></p>
	<p><a href="/Menus/List">메뉴관리</a></p>
	<p>
	<p><a href="/PDS/List?menu_id=MENU01">자료실(Paging)</a></p>
	<!-- 초기에 어떤 메뉴를 보여줄지 결정하기 위해서, 
		또 다른 방법은 SEQ를 줘서 메뉴창 선호도를 설정해서 뿌려줄수 있다.
	  -->

</body>
</html>
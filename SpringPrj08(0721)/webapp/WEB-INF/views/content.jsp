<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel ="stylesheet" href ="/css/common.css"/>

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

<h2>content목록보기</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>

			<tr>
				<td>${content.idx}</td>
				<!-- vo 안에 getter setter이 있어야 하는 이유는 $ 해서 쓰면 getIdx 를 가져온다 -->
				<td>${content.title}</td>
				<td>${content.name}</td>
				<td>${content.regdate}</td>
				<td>${content.count}</td>
				
			</tr>
	</table>
	
	<div class="atag">
			<a href="/Board/WriteForm">새글</a> 
			<a href="/Board/List">목록</a> 
			<a href="/Board/UpdateForm?idx=${content.idx }">수정</a> 
			<a href="/Board/Delete?idx=${content.idx }">삭제</a> 
	</div>		
	<%-- <a href="/Board/WriteForm">새글쓰기</a>
	<a href="/">Main page</a>

	<h1>글내용보기</h1>
	<table>
		<caption>
			<a href="/Board/WriteForm">새글</a> 
			<a href="/Board/List">목록</a> 
			<a href="/Board/UpdateForm?idx=${content.idx }">수정</a> 
			<a href="/Board/Delete?idx=${content.idx }">삭제</a> 
		</caption>
		<tr>
			<th>번호</th>
			<td>${content.idx }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${content.title }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${content.name }</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${content.regdate }</td>
		</tr>
		
	</table> --%>
</body>
</html>
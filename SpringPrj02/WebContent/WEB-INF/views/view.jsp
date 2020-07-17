<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td { border:1px solid green;
	border-collapse:collapse};
	table {
		width:300px;
		margin : 0 auto;
	}
	td:nth-child(1) { width:100px; }
	td:nth-child(2) { width:200px; }

</style>
</head>
<body>
	<table>
		<tr>
		<td>이름</td> 
		<td>${ user.name }</td>
		</tr>
		
		<tr>
		<td>번호</td> 
		<td>${ user.tel }</td>
		</tr>
		
		
		
	</table>
	<a href="/List">목록보기</a>
	<a href="/UpdateForm?tel=${user.tel }">수정</a>
	<a href="/DeleteForm?tel=${user.tel }">삭제</a>
</body>
</html>
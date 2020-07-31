<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href ="/css/common.css"/>
<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">

</head>
<body>
	<h1>메뉴목록</h1>
	<table>
		<tr>
			<th>MENU_ID</th>
			<th>MENU_NAME</th>
			<th>MENU_SEQ</th>
			<th></th>
		</tr>
	
	<c:forEach var="menuVo" items="${menuList }">
		<tr>
				
				<td>${menuVo.menu_id} </td>
				<td>${menuVo.menu_name} </td>
				<td>${menuVo.menu_seq} </td>
				
				<td style="text-align:right">
					<a href="/Menus/UpdateForm?menu_id=${menuVo.menu_id}">
						<img src="/img/edit.png" alt="수정"/>
					</a>
					<a href="/Menus/Delete?menu_id=${menuVo.menu_id}">
						<img src="/img/garbage.png" alt="삭제"/>
					</a>
				</td>
				
		</tr>
	</c:forEach>
	<tr>
				<td colspan="4">
					<a href="/Menus/WriteForm">메뉴추가</a>
					<a href="javascript:history.go(-1)">back</a>
					<a href="javascript:history.reload()">reload</a>
					<a href="javascript:history.go(1)">go</a>
				</td>
	</tr>
	
	
	</table>
	
</body>
</html>
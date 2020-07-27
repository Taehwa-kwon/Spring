<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메뉴목록</h1>
	<table>
		<tr>
			<th>MENU_ID</th>
			<th>MENU_NAME</th>
			<th>MENU_SEQ</th>
		</tr>
	
	<c:forEach var="menuVo" items="${menuList }">
		<tr>
				<td>
					<a href="/Menus/UpdateForm?menu_id=${menuVo.menu_id}">
						<img src="/img/aa.jpg" alt="수정"/>
					</a>
				</td>
				
				<td>
					<a href="/Menus/Delete?menu_id=${menuVo.menu_id}">
						<img src="/img/aa.jpg" alt="삭제"/>
					</a>
				</td>
				
				<td>${menuVo.menu_id} - ${menuVo.menu_name} - ${menuVo.menu_seq}</td>
		</tr>
	</c:forEach>
	</table>
	
	<div>
		<a href="/Menus/WriteForm">메뉴추가</a>
	</div>
	
</body>
</html>
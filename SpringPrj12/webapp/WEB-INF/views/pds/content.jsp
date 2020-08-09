<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.test { height: 300px;}
</style>
<link rel ="stylesheet" href ="/css/common.css"/>
<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">

</head>
<body>
	<h1>글 내용보기</h1>
	
	<%@include file="/WEB-INF/include/menus.jsp" %>
	
	<table>
		<tr >
			<th>작성자</th>
			<td>${pdsVo.writer }</td>
			<th>작성일</th>
			<td>${pdsVo.regdate }</td>
		</tr>
		<tr >
			<th>글번호</th>
			<td>${pdsVo.bnum }</td>
			<th>조회수</th>
			<td>${pdsVo.readcount }</td>
		</tr>
		<tr >
			<th>글제목</th>
			<td colspan="3">${pdsVo.title }</td>
		</tr>
		
		<tr >
			<th>내용</th>
			<td colspan="3" class="test">${pdsVo.cont }</td>
		</tr>
		
		<tr >
			<th>파일</th>
			<td colspan="4">
				<c:forEach var="fileVo" items="${fileList}">
					<a href="<c:out value='/download/external/${fileVo.filename}'/>">
						${fileVo.filename}
					</a>
				</c:forEach>
			</td>
		</tr>
		
		<tr>
			<td colspan="4">
				
				<a href="/PDS/List?menu_id=MENU01&nowpage=1&pagecount=2&pagegrpnum=1">목록보기</a>
				
				<a href="/PDS/WriteForm?menu_id=${pdsVo.menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${map.nowpage}&pagegrpnum=${map.pagegrpnum}&pagecount=${map.pagecount}">새글쓰기</a>
				<a href="/PDS/WriteForm?menu_id=${pdsVo.menu_id}&bnum=${pdsVo.bnum }&lvl=${pdsVo.lvl }&step=${pdsVo.step}&nref=${pdsVo.nref}&nowpage=${map.nowpage}&pagegrpnum=${map.pagegrpnum}&pagecount=${map.pagecount}">답글쓰기</a>
			<c:choose>
			<c:when test="${pdsVo.writer eq login.userId}">
				<a href="/PDS/Delete?idx=${pdsVo.idx}&nref=${pdsVo.nref}&lvl=${pdsVo.lvl}&step=${pdsVo.step}&menu_id=${pdsVo.menu_id}&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}">삭제</a>
				<a href="/PDS/UpdateForm?idx=${pdsVo.idx}&menu_id=${pdsVo.menu_id}&bnum=${pdsVo.bnum }&lvl=${pdsVo.lvl }&step=${pdsVo.step} &nref=${pdsVo.nref}&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}">수정</a>
			</c:when>	
			</c:choose>	
				
			</td>
		</tr>
		
		
		
	</table>
</body>
</html>
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
	<h1>${pdsVo.menu_id }자료실 목록보기</h1>
	
	<!-- 방법1 -->
	<%@include file="/WEB-INF/include/menus.jsp" %>
	<!-- 방법2 <jsp:include page=""></jsp:include>  -->
	
	<table>
		<tr style="background-color:rgba(255, 255, 128, .5)">
			<td>글번호</td>		
			<td>제목</td>		
			<td>작성자</td>		
			<td>조회수</td>
			<td>파일명</td>		
			<td>작성일</td>		
		</tr>
		
		<c:forEach var="pdsVo" items="${pdsList}">
		<tr>
			<td>${pdsVo.idx }</td>
			<td>${pdsVo.title }</td>
			<td>${pdsVo.writer }</td>
			<td>${pdsVo.readcount }</td>
			<td><a href="<c:out value='/download/external/${pdsVo.filename }'/>">${pdsVo.filename }</a></td>
			<!-- 이 c:out 문법 보기- 심플한코딩백과사전에서 c:out태그를 사용하는 이유 보기  -->
			<!-- 여기서 대박인게 value의 /download/external/${pdsVo.filename} 인데 이게 Controller에서 RequestMapping으로 간다. -->
			<td>${pdsVo.regdate }</td>
		</tr>	
		</c:forEach>
		<tr>
			<td colspan="6">
				<a href="/PDS/WriteForm?bnum=0&menu_id=${pdsVo.menu_id }&nref=0&step=0&lvl=0">새글쓰기</a> 
				<!-- 여기서 bnum = 0을주고 그러면 프로시저에서 IF IN_BNUM=0이다  이게 완성이 된다.-->
				<a href="javascript:history.go(-1)">back</a>
				<a href="javascript:history.reload()">reload</a>
				<a href="javascript:history.go(1)">go</a>
			</td>
		</tr>
	</table>

</body>
</html>
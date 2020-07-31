<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel ="stylesheet" href ="/css/common.css"/>
<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset="UTF-8">

<!-- 여기가 부품이래.이 부품이 뭘하냐면 list에서 menus.jsp(여기)내용을 가져간다.
top 메뉴 , bottom메뉴 jsp를 따로 만든다. 
하나의 페이지에다가 자리를 정해서 .

방법1.이렇게 쓸수있는 기술은 include file < 컴파일 전에 이러한 조각들을 가져와서 list.jsp에 붙여서 한방에 실행시킨다.
방법2.얘는 먼저 page= "" 에 해당하는게 먼저 실행되는데 그것을 다시 list에 가져다 준다.  -->
 

<div>새로운 기술 include file 메뉴만 가져오기</div> 
	<table border="1">
		<tr style="background-color:rgba(255, 255, 128, .5)">
			<c:forEach var="menuVo" items="${menuList }">
				<td>
					<a href="/PDS/List?menu_id=${menuVo.menu_id }">${menuVo.menu_name}</a>
				</td>
			</c:forEach>
		</tr>
	</table>
	
	

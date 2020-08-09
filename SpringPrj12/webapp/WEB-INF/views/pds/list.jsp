<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="/css/common.css" />
</head>
<body>
  <h1>Pds List.JSP</h1>
  
  <!-- 메뉴 -->
  <%@ include file = "/WEB-INF/include/menus.jsp"%>

	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>파일</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<!-- 목록 -->
		<c:forEach var="pdsVo" items="${ pdsList }">
			<tr>
				<td style="padding-left:${100}px">
				<c:choose>
						<c:when test="${ pdsVo.lvl eq 0 }">
                     		${ pdsVo.bnum }
                  		</c:when>
						
						<c:otherwise>

						</c:otherwise>
				</c:choose>
				</td>
				
				<td style="padding-left:${pdsVo.lvl*10}px">
				<c:choose>
						<c:when test="${ pdsVo.lvl eq 0 }">
							<c:choose>
								<c:when test="${ pdsVo.delnum eq 0 }">
									<a href="/PDS/Content?idx=${ pdsVo.idx }&menu_id=${ pdsVo.menu_id }&nowpage=${pagePdsVo.nowpage  }&pagegrpnum=${ pagePdsVo.pagegrpnum }&pagecount=${pagePdsVo.pagecount}">${ pdsVo.title }</a>
						</c:when>
								<c:otherwise>
                           			삭제된 글입니다.
                        		</c:otherwise>
							</c:choose>
						</c:when>

						<c:otherwise>
							<c:choose>
								<c:when test="${ pdsVo.delnum eq 0 }">
									<a href="/PDS/Content?idx=${ pdsVo.idx }&menu_id=${ pdsVo.menu_id }&nowpage=${pagePdsVo.nowpage }&pagegrpnum=${ pagePdsVo.pagegrpnum }&pagecount=${pagePdsVo.pagecount}">${ pdsVo.title }</a>
								</c:when>
								
								<c:otherwise>
                           			삭제된 글입니다.
                        		</c:otherwise>
							</c:choose>
						</c:otherwise>
				</c:choose>
				</td>
				
				<td>
				${ login.userId }
				<%-- ${pdsVo.writer } --%>
				</td>
				<td>${pdsVo.filecount }</td>
				<td>${pdsVo.regdate }</td>
				<td>${pdsVo.readcount }</td>
			</tr>
		</c:forEach>

	</table>

	<!-- 페이징 처리 -->
   
   <%@include file="/WEB-INF/include/paging.jsp"%>
  <a href="/logout">로그아웃</a>
  <a href="/PDS/WriteForm?menu_id=${menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${nowpage}&pagegrpnum=${pagegrpnum}&pagecount=2&a=${param.a}">새글쓰기</a>
  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>


<div style="text-align:center">
	<table>
		<tr>
			<td>
				<c:set var="showprev" value="${pagePdsVo.isshowpageprev }"/>
				<c:set var="shownext" value="${pagePdsVo.isshowpagenext }"/>
				
				<c:set var="startnum" value="${pagePdsVo.pagestartnum }"/>
				<c:set var="endnum" value="${pagePdsVo.pageendnum }"/>
				<c:set var="pagegrpnum" value="${pagePdsVo.pagegrpnum }"/>
				
				<c:set var="recordcount" value="${pagePdsVo.recordcount}"/>
				<c:set var="pagecount" value="${pagePdsVo.pagecount}"/>
				<c:set var="totalpagecount" value="${pagePdsVo.totalpagecount}"/>
				
				<c:set var="nowpage" value="${pagePdsVo.nowpage }"/>
				<c:set var="prevnowpage" value="${pagePdsVo.prevnowpage }"/>
				<c:set var="nextnowpage" value="${pagePdsVo.nextnowpage }"/>
				
				<c:set var="menu_id" value="${pagePdsVo.menu_id }"/>
				
				<c:if test="${showprev eq true}">
					<a href="http://localhost:9090/PDS/List?menu_id=${menu_id }&nowpage=${prevnowpage }&pagecount=${pagecount}&pagegrpnum=${pagegrpnum-1}">		
				◀  이전    ${totalpagecount}
					</a>
				</c:if>
				
				<c:forEach var="pagenum" begin="${startnum}" end="${endnum}" step="1" >
					  <a href="http://localhost:9090/PDS/List?menu_id=${menu_id }&nowpage=${pagenum }&pagecount=${pagecount}&pagegrpnum=${pagegrpnum}">${pagenum }</a> 
				</c:forEach>

				<c:if test="${shownext eq true}">
					<a href="http://localhost:9090/PDS/List?menu_id=${menu_id }&nowpage=${nextnowpage }&pagecount=${pagecount}&pagegrpnum=${pagegrpnum+1}">
				▶  다음  ${totalpagecount}
				</a>
				</c:if>
				
  			</td>
		</tr>	
	</table>
</div> 
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

<style>
	.test { height: 300px;}
	#err_title { color:red;}
</style>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>
	function inputCheck(){
		if($("[name=writer]").val() =='') return false;
		if($("[name=title]").val() ==''){
				$('#err_title').html("제목을 입력하시오");
				return false; 
			}
		if($("[name=cont]").val() =='') return false;
			
			return true;
	}
	$(function(){
		$('#form1').on('submit',function(e){
			var isValid =inputCheck();
			if(isValid){
				return true;
			}
			else {
				return false;
			}	
		})
	});
	
	
</script>

</head>
<body>
	<h1>글 수정하기</h1>
	
	<%@include file="/WEB-INF/include/menus.jsp" %>
	<form id="form1" action="/PDS/Update" method="POST" enctype="mutipart/form-data">
		<table>
				
			<tr >
				<th>작성자</th>
				<td><input type="text" name="writer" value="${pdsVo.writer }"/></td>
				<th>작성일</th>
				<td><input type="text" name="regdate" value="${pdsVo.regdate }"/></td>
			</tr>
			<tr >
				<th>글번호</th>
				<td><input type="text" name="bnum" value="${pdsVo.bnum }"/></td>
				<th>조회수</th>
				<td><input type="text" name="readcount" value="${pdsVo.readcount }"/></td>
			</tr>
			<tr >
				<th>글제목</th>
				<td colspan="3">
					<input type="text" name="title" value="${pdsVo.title }"> 
					<span class="blinking" id="err_title" ></span>
				</td>
			</tr>
			
			<tr >
				<th>내용</th>
				<td colspan="3" class="test">
					<textarea name="cont" rows="4" cols="50" placeholder="내용을 입력하시오">${pdsVo.cont }</textarea> 
				</td>
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
					<input type="submit" value="수정"/>
					<a href="/PDS/List?menu_id=${pdsVo.menu_id}&bnum=${pdsVo.bnum}&lvl=${pdsVo.lvl}&step=${pdsVo.step}&nref=${pdsVo.nref}&nowpage=1&pagecount=2&pagegrpnum=1">록록</a>
					
					<input type="hidden" name="idx" value="${pdsVo.idx }"/>
					<input type="hidden" name="menu_id" value="${ pdsVo.menu_id }"/>
					<input type="hidden" name="nowpage" value="${ map.nowpage }"/>
					<input type="hidden" name="pagecount" value="${ map.pagecount }"/>
					<input type="hidden" name="pagegrpnum" value="${ map.pagegrpnum }"/>
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자료실 새글쓰기</h1>

	<%@include file="/WEB-INF/include/menus.jsp" %>
	

	<form action="/PDS/Write" method="POST" encType="multipart/form-data">
	<!-- form태그는 name의 이름을 타고 url을 통해서 전달되고 Vo의 이름과 같아야 전달이 된다. -->
	<!-- enctype이 있어야 파일이 넘어간다.  -->
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"/></td>
			</tr>		
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"/></td>
			</tr>		
			<tr>
				<td>내용</td>
				<td><textarea name="cont" rows="4" cols="50" placeholder="내용을 입력하시오" required="required"></textarea> </td>
			</tr>		
			<tr>
				<td>파일</td>
				<td><input type="file" name="upfile"/></td>
			</tr>	
			<!--  MENU_ID , BNUM, LVL, STEP, NREF를 Controller의 /PDS/Write를 전달해야 한다.  -->
			<input type="hidden" name="menu_id" value="${pdsVo.menu_id }" />
			<input type="hidden" name="bnum" value="${pdsVo.bnum }" />
			<input type="hidden" name="lvl" value="${pdsVo.lvl }" />
			<input type="hidden" name="step" value="${pdsVo.step }" />
			<input type="hidden" name="nref" value="${pdsVo.nref }" />

			<tr>
				<td colspan="5"><input type="submit" value="저장"/> 
				<a href="javascript:history.go(-1)">back</a>
				<a href="javascript:history.reload()">reload</a>
				<a href="javascript:history.go(1)">go</a>
				</td>
			</tr>		
		</table>
	</form>
	
</body>
</html>
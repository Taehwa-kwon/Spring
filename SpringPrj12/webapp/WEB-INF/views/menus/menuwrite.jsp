<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Menus/Write" method="POST">
		여기 input name의 이름과 MenuVo vo의 변수명과 같아야 한다. 이유는 form이 Write로 전달되어서 매개변수가 MenuVo라서
		매개변수 MenuVo의 역할은 setter을 자동으로 해준다. <br/>
		 
		메뉴이름
		<input type="text" name="menu_name"/>
		<input type="submit" value="추가"/>
		
	
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>넘어온 값</h2>
	<p>a:${vo.a }</p>
	<p>b:${vo.b }</p>
	<hr>
	<p>a:${attrName.a }</p>
	<p>b:${attrName.b }</p>
	<hr>
	<p>a:${param.a } (request.getParamaeter("a"))</p>
	<p>b:${param.b } (request.getParamaeter("b"))</p>
	<hr>
	
	Express Language 라는 문법인데 달러와 대괄호를 이용하여 vo 객체안의 getName과 같은 getter setter을 바로 사용가능  
	(request.getParamaeter("a") 이 문장을 줄여서  이게 가능 
	

</body>
</html>
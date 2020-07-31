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
  
  <!-- 목록 -->
  
  <a href = "/PDS/WriteForm?menu_id=${menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${nowpage}&pagegrpnum=${pagegrpnum}">새글쓰기</a>
  
</body>
</html>
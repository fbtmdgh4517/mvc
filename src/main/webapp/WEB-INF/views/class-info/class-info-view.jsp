<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>class info view</h3>
<%
	Map<String, String> classInfo = (Map<String, String>)request.getAttribute("classInfo");
%>

</body>
</html>
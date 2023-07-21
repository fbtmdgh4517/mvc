<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>user view</h3>
<table border="15" style="border-color: green; border-style: dashed;">
	<tr>
		<th>번호</th>
		<td>${userInfo.uiNum}</td>
	</tr>
	<tr>
		<th>아이디</th>
		<td>${userInfo.uiId}</td>
	</tr>
	<tr>
		<th>비번</th>
		<td>${userInfo.uiPwd}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${userInfo.uiName}</td>
	</tr>
</table>
</body>
</html>
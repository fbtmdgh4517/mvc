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
<form action="/class-info/delete" method="POST">
<input type="hidden" name="ciNum" value="${classInfo.ciNum}">
<table border="15" style="border-color: green; border-style: dashed;">
	<tr>
		<th>num</th>
		<td>${classInfo.ciNum}</td>
	</tr>
	<tr>
		<th>name</th>
		<td>${classInfo.ciName}</td>
	</tr>
	<tr>
		<th>desc</th>
		<td>${classInfo.ciDesc}</td>
	</tr>
	<tr>
		<th>
			<button onclick="location.href='/class-info/update?ciNum=${classInfo.ciNum}'">수정</button>
			<button>삭제</button>
		</th>
	</tr>
</table>
</form>
</body>
</html>
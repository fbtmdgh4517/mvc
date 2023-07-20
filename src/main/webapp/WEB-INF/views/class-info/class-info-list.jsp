<%@page import="java.util.List"%>
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
<h3>강의 리스트</h3>
<%
	List<Map<String, String>> classInfoList = (List<Map<String, String>>)request.getAttribute("classInfoList"); 
%>
<table border="15" style="border-color: green; border-style: dashed;">
	<tr>
		<th>num</th>
		<th>name</th>
		<th>desc</th>
	<tr>
<%
	for(Map<String, String> classInfo : classInfoList) {
%>
		<tr>
			<td><%=classInfo.get("ciNum") %></td>
			<td><a href="/class-info/view?ciNum=<%=classInfo.get("ciNum") %>"><%=classInfo.get("ciName") %></a></td>
			<td><%=classInfo.get("ciDesc") %></td>
		</tr>
<%
	}
%>
</table>
</body>
</html>
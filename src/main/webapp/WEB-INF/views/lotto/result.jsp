<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>결과</h3>
맞춘 개수는 <%=request.getAttribute("result") %>
정답은 <%=request.getAttribute("lotto") %>
</body>
</html>
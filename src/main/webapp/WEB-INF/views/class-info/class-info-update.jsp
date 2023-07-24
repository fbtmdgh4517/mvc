<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>class info update</h3>
<form action="/class-info/update" method="POST">
<input type="hidden" name="ciNum" value="${classInfo.ciNum}">
<input type="text" name="ciName" value="${classInfo.ciName}">
<input type="text" name="ciDesc" value="${classInfo.ciDesc}">
<button>수정</button>
</form>
</body>
</html>
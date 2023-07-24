<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>movie update</h3>
<form action="/movie-info/update" method="POST">
	<input type="hidden" name="miNum" value="${movieInfo.miNum}">
	<input type="text" name="miTitle" value="${movieInfo.miTitle}">
	<input type="text" name="miDesc" value="${movieInfo.miDesc}">
	<input type="text" name="miGenre" value="${movieInfo.miGenre}">
	<input type="date" name="miCredate" value="${movieInfo.miCredate}">
	<input type="number" name="miCnt" value="${movieInfo.miCnt}">
	<button>수정</button>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>movie insert</h3>
<form action="/movie-info/insert" method="POST">
	<input type="text" name="miTitle" placeholder="영화 제목">
	<input type="text" name="miDesc" placeholder="영화 설명">
	<input type="text" name="miGenre" placeholder="영화 장르">
	<input type="date" name="miCredate" placeholder="개봉일">
	<input type="number" name="miCnt" placeholder="관객수">
	<button>등록</button>
</form>
</body>
</html>
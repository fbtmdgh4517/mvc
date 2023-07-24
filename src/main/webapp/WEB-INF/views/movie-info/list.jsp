<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>movie list</h3>
<table border="25" style="border-color: green; border-style: dashed;">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>설명</th>
		<th>장르</th>
		<th>개봉일</th>
		<th>관객수</th>
	</tr>
	<c:forEach items="${movieInfoList}" var="movieInfo">
		<tr>
			<td>${movieInfo.miNum}</td>
			<td>
				<a href="/movie-info/view?miNum=${movieInfo.miNum}">${movieInfo.miTitle}</a>
			</td>
			<td>${movieInfo.miDesc}</td>
			<td>${movieInfo.miGenre}</td>
			<td>${movieInfo.miCredate}</td>
			<td>${movieInfo.miCnt}</td>
		</tr>
	</c:forEach>
	<tr>
		<td align="right" colspan="6">
			<button onclick="location.href='/movie-info/insert'">등록</button>
		</td>
	</tr>
</table>
</body>
</html>
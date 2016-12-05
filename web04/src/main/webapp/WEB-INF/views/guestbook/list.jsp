<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp"%>
<!-- /WEB-INF/views/guestbook/list.jsp -->
<div style="width: 600px; ">
	게시물 수 : ${count},   
	<a href="${path}/guestbook/write"> 글쓰기</a>
	<br>
	<span style="color: red;">${param.message}</span>
</div>

<c:forEach var="row" items="${items}">
<form action="${path}/guestbook/view">
<table border="1" style="width: 600px;">
	<tr>
		<td>이름</td>
		<td>${row.name}</td>
		<td>날짜</td>
		<td>${row.post_date}</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td colspan="3">${row.email}</td>
	</tr>
	<tr>
		<td>컨텐츠</td>
		<td colspan="3">${row.content}</td>
	</tr>
    <tr>
		<td colspan="4">
		비밀번호
		<input type="hidden" name="idx" value="${row.idx}">
		<input type="password" name="passwd">
		<input type="submit" value="수정/삭제">
	</tr>
</table>
</form>
</c:forEach>
</body>
</html>
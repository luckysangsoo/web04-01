<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<!-- 세션 값 체크가 필요한 페이지에 sessionCheck.jsp를 include 시킴 -->
<%@ include file="../include/sessionCheck.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>게시판 글쓰기</h2>
<!-- 파일을 첨부할려면 method="post" enctype="multipart/form-data" 필수 -->
<form name="form1" method="post" enctype="multipart/form-data"
action="${path}/board/write.do">
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input name="subject" size="50"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="5" cols="50" name="content"></textarea></td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td><input type="file" name="file1"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="확인">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
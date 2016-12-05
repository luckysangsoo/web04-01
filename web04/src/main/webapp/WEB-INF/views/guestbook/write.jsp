<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp"%>
<h2 style="text-align: center;">방명록 작성</h2> 
<form name="form1" method="post" action="${path}/guestbook/write">
<table align="center" border="1" style="width:500px;">
	<tr>
		<td>이름</td>
		<td><input name="name" size="20" value="${sessionScope.name}"></td>
	</tr>
    <tr>
		<td>이메일</td>
		<td><input name="email" size="40"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="content" rows="5" cols="55"></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="확인">
			<input type="reset" value="취소">
        </td>
	</tr>
</table>
</form>
</body>
</html>
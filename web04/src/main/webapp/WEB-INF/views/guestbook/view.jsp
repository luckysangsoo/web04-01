<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	$("#btnUpdate").click(function(){
		// GuestbookController로 수정 할 자료 전송
		document.form1.action="${path}/guestbook/update";
		document.form1.submit();
	});
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="${path}/guestbook/delete";
			document.form1.submit();
		}
	});
	
});

</script>
</head>
<body>
<%@ include file="../include/menu.jsp"%>
<!-- WEB-INF/views/guestbook/view.jsp -->
<form name="form1">
<table border="1" style="width: 600px;">
	<tr>
		<td>이름</td>
		<td><input name="name" value="${dto.name}"></td>
		<td>날짜</td>
		<td>${dto.post_date}</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td colspan="3" ><input name="email" value="${dto.email}"></td>
	</tr>
	<tr>
		<td>컨텐츠</td>
		<td colspan="3" ><textarea name="content" rows="5" cols="60">${dto.content}</textarea></td>
	</tr>
    <tr>
		<td colspan="4">
		비밀번호
		<input type="hidden" name="idx" value="${dto.idx}">
		<input type="button" value="수정" id="btnUpdate">
		<input type="button" value="삭제" id="btnDelete">
	</tr>
</table>
</form>
</body>
</html>
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
<!-- < WEB-INF/views/shop/product_write.jsp -->
<h2>상품등록</h2>
 <!-- 파일 업로드는 반드시 post 방식으로
 multipart/form-data로 대량의 파일을 나눠서 전송해야 함 -->
<form name="form1" method="post" enctype="multipart/form-data"
 action="${path}/shop/product_write">
<table>
	<tr>
		<td>상품명</td>
		<td><input name="product_name"></td>
	</tr>
    <tr>
		<td>가격</td>
		<td><input name="price"></td>
	</tr>
	<tr>
		<td>상품설명</td>
		<td><textarea rows="5" cols="60" name="description"></textarea>
		</td>
	</tr>
	<tr>
		<td>상품이미지</td>
		<td><input type="file" name="file1"></td>
	</tr>
    <tr>
		<td colspan="2">
		  <input type="submit" value="확인" id="btnAdd">
		</td>
	</tr>
</table>
</form>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- WEB-INF/views/shop/product_list.jsp -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp"%>
<h2 style="text-align: center;">상품 목록</h2>
<!-- 관리자 계정인 경우 상품등록 버튼 표시
if test="조건식" -->
<div style="text-align: center;">
<c:if test="${sessionScope.id == 'admin' }">
	<input type="button" value="상품등록" 
	onclick="location.href='${path}/shop/product_write' ">
</c:if>
<!-- 톰캣이 관리하는 배포 경로 확인 -->
<!-- root 경로 확인 -->
<br>
<% out.println(application.getRealPath("/")); %>

<table border="1" align="center" width="400px">
	<tr>
		<th>상품ID</th>
		<th>상품명</th>
		<th>가격</th>
	</tr>
<c:forEach var="row" items="${list}">
	<tr>
		<td>${row.product_id}</td>
		<td><a href="${path}/shop/product_detail?product_id=${row.product_id}">
		<img src="${path}/images/${row.picture_url}" width="100px" height="100px"><br>
		${row.product_name}</a></td>
		<td>${row.price}</td>
	</tr>
</c:forEach>	
</table>
</div>
</body>
</html>
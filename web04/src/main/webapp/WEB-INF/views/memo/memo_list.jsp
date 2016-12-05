<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- memoList 출력 -->
<br>
<%@ include file="../include/header.jsp" %>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>메모</th>
		<th>날짜</th>
	</tr>
	<c:forEach var="row" items="${list}">
		<tr>
			<td>${row.idx}</td>
			<td>${row.writer}</td>
			<td>${row.memo}</td>
			<td>${row.write_date}</td>
		</tr>	
	</c:forEach>
</table>
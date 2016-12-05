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
<%@ include file="../include/menu.jsp" %>
<h2>게시판</h2>
<a href="${path}/board/write.do">글쓰기</a>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>제목</th>
		<th>날짜</th>
		<th>조회</th>
		<th>첨부파일</th>
		<th>다운로드</th>
	</tr>
<c:forEach var="row" items="${list}">
	<tr>
		<td>${row.idx}</td>
		<td>${row.name}</td>
		<td>${row.subject}</td>
		<td>${row.post_date}</td>
		<td>${row.hit}</td>
		<td align="center">
		<!-- 첨부파일의 사이즈가 0 보다 크면 파일 다운로드 링크 표시 -->
			<c:if test="${row.filesize > 0 }">
				<a href="${path}/board/down.do?idx=${row.idx}">
					<img src="${path}/images/contbig.gif">
				</a>
			</c:if>
		</td>
		<td>${row.down}</td>
	</tr>
</c:forEach>	
</table>
</body>
</html>
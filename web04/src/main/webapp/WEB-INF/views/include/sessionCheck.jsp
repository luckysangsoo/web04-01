<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- WEB-INF/views/include/sessionCheck.jsp -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.id == null }">
	<script>
		alert("로그인 하신 후 사용하시기 바랍니다.");
		location.href="${path}/member/login";
	</script>
</c:if>

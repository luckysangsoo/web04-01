<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- pageContext.request.contextPath
컨텍스트 이름을 리턴(request.getContext()과 같음) -->
<!-- set var="변수명" value="값" -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!-- WEB-INF/views/include/header.jsp -->
<!-- 상단메뉴 구성 -->
<div style="text-align: center;">
    <!-- <a href="/web04/guestbook/list">방명록</a> -->
	<a href="${path}/guestbook/list">방명록</a>
	<a href="${path}/memo/list">한줄메모장</a>
	<a href="${path}/shop/product_list">상품관리</a>
	<c:if test="${sessionScope.id != null }">
		<a href="${path}/shop/cart_list">장바구니</a>
	</c:if>
	<a href="${path}/board/board_list.do">게시판</a>
	<c:choose>
		<c:when test="${sessionScope.id == null}">
			<a href="${path}/member/login">로그인</a>		
		</c:when>
		<c:otherwise>
		    <!-- 세션 변수 값이 있을 때 -->
			[ ${sessionScope.id} 님 로그인중 ]
			<a href="${path}/member/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
		
</div>
<hr>
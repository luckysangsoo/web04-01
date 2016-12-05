<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
$(document).ready(function(){
	//웹페이지 로딩이 완료되면 list()가 자동 실행 됨.
	list();	
	
	//버튼클릭 이벤트 등록
	$("#btnAdd").click(function(){
		memoAdd();
	});
	
});

//메모 추가 함수
function memoAdd(){
// 태그.val() : 태그에 입력된 값을 읽음(getter)
// 태그.val(값) : 태그에 값을 입력 함(setter)
// url?key=value&key=value
	var param=
		"writer="+$("#writer").val()+"&memo="+$("#memo").val();
	$.ajax({
		type: "post",
		data: param,
		url: "${path}/memo/memo_add",
		success: function(){
			list(); // 메모리스트를 갱신 함.
		}
	});
}

function list(){
		// ajax 방식으로 div 태그의 내용을 교환
		// success function 의  변수는 responseText(서버의 응답 내용)
	$.ajax({
		type: "post",
		url: "${path}/memo/memo_list",
		success: function(result){
			// div 태그의 내용 교체
			$("#divList").html(result);
		}
	});
}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp"%>
이름 : <input id="writer" size="20"><br>
메모 : <input id="memo" size="50"><br>
<input type="button" id="btnAdd" value="확인">
<div id="divList">이 영역에 출력합니다.</div>
</body>
</html>
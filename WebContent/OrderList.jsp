<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문 목록</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<style>
	body{
		background-image:url("css/rocket.JPG");
	}
</style>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
function buttonclick(s) {
	alert( "배송 완료인 주문만 삭제할 수 있습니다." );
}

</script>
</head>
<body>
	<article class="main">
		<section>
			<table width="80%"  align="center"  >
			<caption class="caption">주문 목록</caption>
			<thead>
				<tr align="center"><th>주문번호</th><th>상품ID</th><th>상품이름</th><th>가격</th><th>갯수</th><th>진행상황</th><th>삭제</th></tr>
			</thead>
			<tbody id="content">
				<c:forEach var="vo" items="${order_list}">
					<tr align="center"><td>${vo.id }</td><td>${vo.pid }</td><td>${vo.name }</td><td>${vo.price}</td>
					<td>${vo.number }</td><td>${vo.process }</td>
					<td><button id="delbtn" value="${vo.id }" onclick="buttonclick('${vo.id }');">삭제</button>
				</c:forEach>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="CustomerIndex.jsp">메인 페이지로</a> 
				<a href="order.do?action=order">주문하러 가기</a> 
			</td></tr>
			</table>
		</section>
	</article>
</body>
</html>
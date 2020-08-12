<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>주문하기</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<style>
	body{
		background-image:url("css/rocket.JPG");
	}
</style>
<script type="text/javascript">
function buttonclick(s) {
	alert( s+"을(를) 주문했습니다.\n주문 완료시 주문목록으로 이동합니다." );
}

</script>
</head>
<body>
	<article class="main">
		<section>
			<table width="80%"  align="center"  >
			<caption class="caption">주문 하기</caption>
			<thead>
				<tr align="center"><th></th><th>상품이름</th><th>분야</th><th>가격</th><th>재고수량</th><th>갯수</th><th>주문</th></tr>
			</thead>
			<tbody id="content">
				<tr align="center">${ordermsg}</tr>
				<c:forEach var="vo" items="${list}" >
					<form action="order.do?action=save" method="post">
						<tr align="center"><td><input type="hidden" name="pid" value="${vo.pid }"/></td>
						<td>${vo.name }</td>
						<td>${vo.kind }</td>
						<td>${vo.price}</td>
						<td>${vo.number }</td>
						<td><input type="number" name="number"/></td>
						<td><input type="submit" value="주문" onclick="buttonclick('${vo.name }');"/></td>
					</form>
				</c:forEach>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="CustomerIndex.jsp">메인 페이지로</a> 
				<a href="order.do?action=list">주문 목록</a> 
			</td></tr>
			</table>
		</section>
	</article>
</body>
</html>
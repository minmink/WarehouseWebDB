<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>출고 목록</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<style>
	body{
		background-image:url("css/rocket.JPG");
	}
</style>
</head>
<body>
	<article class="main">
		<section>
			<table width="80%"  align="center"  >
			<caption class="caption">출고 목록</caption>
			<thead>
				<tr align="center"><th>번호</th><th>주문번호</th><th>상품ID</th><th>갯수</th><th>직원ID</th><th>고객ID</th></tr>
			</thead>
			<tbody id="content">
				<c:forEach var="vo" items="${list}" >
						<tr align="center">
						<td>${vo.id }</td>
						<td>${vo.rid }</td>
						<td>${vo.pid}</td>
						<td>${vo.number }</td>
						<td>${vo.eid }</td>
						<td>${vo.cid }</td></tr>
				</c:forEach>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="admin.jsp">메인 페이지로</a>
				<a href="admin.do?action=wlist">입고 목록</a> 
			</td></tr>
			</table>
		</section>
	</article>
</body>
</html>
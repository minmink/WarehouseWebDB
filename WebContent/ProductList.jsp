<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>제품 목록</title>
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
			<caption class="caption">재고 목록</caption>
			<thead>
				<tr align="center"><th>상품ID</th><th>상품이름</th><th>분류</th><th>가격</th><th>갯수</th><th>장소</th></tr>
			</thead>
			<tbody id="content">
				<c:forEach var="vo" items="${list}">
					<tr align="center"><td>${vo.pid }</td><td>${vo.name }</td><td>${vo.kind }</td><td>${vo.price}</td>
					<td>${vo.number }</td><td>${vo.space }</td>
				</c:forEach>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="EmployeeIndex.jsp">메인 페이지로</a> 
				<a href="work.do?action=waitinglist">입고하러 가기</a> 
				<a href="work.do?action=releaselist">출고하러 가기</a> 
			</td></tr>
			</table>
		</section>
	</article>
</body>
</html>
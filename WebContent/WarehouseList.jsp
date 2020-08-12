<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Ӱ� ���</title>
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
			<caption class="caption">�԰� ���</caption>
			<thead>
				<tr align="center"><th>��ȣ</th><th>�԰���ȣ</th><th>��ǰID</th><th>����</th><th>����ID</th></tr>
			</thead>
			<tbody id="content">
				<c:forEach var="vo" items="${list}" >
						<tr align="center">
						<td>${vo.id }</td>
						<td>${vo.rid }</td>
						<td>${vo.pid}</td>
						<td>${vo.number }</td>
						<td>${vo.eid }</td></tr>
				</c:forEach>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="admin.jsp">���� ��������</a>
				<a href="admin.do?action=rlist">��� ���</a> 
			</td></tr>
			</table>
		</section>
	</article>
</body>
</html>
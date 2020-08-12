<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�ֹ� ���</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<style>
	body{
		background-image:url("css/rocket.JPG");
	}
</style>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
function buttonclick(s) {
	alert( "��� �Ϸ��� �ֹ��� ������ �� �ֽ��ϴ�." );
}

</script>
</head>
<body>
	<article class="main">
		<section>
			<table width="80%"  align="center"  >
			<caption class="caption">�ֹ� ���</caption>
			<thead>
				<tr align="center"><th>�ֹ���ȣ</th><th>��ǰID</th><th>��ǰ�̸�</th><th>����</th><th>����</th><th>�����Ȳ</th><th>����</th></tr>
			</thead>
			<tbody id="content">
				<c:forEach var="vo" items="${order_list}">
					<tr align="center"><td>${vo.id }</td><td>${vo.pid }</td><td>${vo.name }</td><td>${vo.price}</td>
					<td>${vo.number }</td><td>${vo.process }</td>
					<td><button id="delbtn" value="${vo.id }" onclick="buttonclick('${vo.id }');">����</button>
				</c:forEach>
			</tbody>
			</table>
		</section>
		<section class="link">
			<table   align="center">
			<tr><td align="center">
				<a href="CustomerIndex.jsp">���� ��������</a> 
				<a href="order.do?action=order">�ֹ��Ϸ� ����</a> 
			</td></tr>
			</table>
		</section>
	</article>
</body>
</html>